package com.back.team.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.back.team.dao.TeamDAO;
import com.back.team.dto.TeamDTO;

@Service
public class TeamService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	TeamDAO teamDAO;

	private final String ROOT = "/usr/local/tomcat/webapps/teamLogo/";

	public TeamDTO teamDetail(int team_idx) {
		return teamDAO.teamDetail(team_idx);
	}

	public Map<String, Object> list(int page, int team_idx, String id) {
        int start = (page - 1) * 10;
        int limitNum = 0;
        if (start == 0) {
            limitNum = 9;
        } else {
            limitNum = 10;
        }
        Map<String, Object> result = new HashMap<>();
        List<TeamDTO> listTeam = teamDAO.listTeam(start, team_idx);
        // 팀원 신청내역
        List<TeamDTO> listAppli = teamDAO.listAppli(start, team_idx);
        // 게스트 신청내역
        List<TeamDTO> listAppliGuest = teamDAO.listAppliGuest(start, team_idx);

        List<TeamDTO> listWriteTeam = teamDAO.listWriteTeam(team_idx, id);
        List<TeamDTO> listWriteGuest = teamDAO.listWriteGuest(start, team_idx, id, limitNum);
        List<TeamDTO> listDrop = teamDAO.listDrop(start, team_idx);
        int totalPageWrite = teamDAO.writeTotal(team_idx, id);
        logger.info(totalPageWrite+"");
        result.put("listTeam", listTeam);
        result.put("totalPageTeam", teamDAO.teamTotal(team_idx));
        result.put("listAppli", listAppli);
        result.put("totalPageAppli", teamDAO.appliTotal(team_idx));
        result.put("listAppliGuest", listAppliGuest);
        result.put("totalPageAppliGuest", teamDAO.appliGuestTotal(team_idx));
        result.put("listWriteTeam", listWriteTeam);
        result.put("listWriteGuest", listWriteGuest);
        result.put("totalPageWrite", teamDAO.writeTotal(team_idx, id));
        result.put("listDrop", listDrop);
        result.put("totalPageDrop", teamDAO.dropTotal(team_idx));

        return result;
    }

	public TeamDTO userPop(String userId) {
		return teamDAO.userPop(userId);
	}

	public int dropMember(int team_idx, String userId) {
		String teamName = teamDAO.teamName(team_idx);
		String msg = teamName + " 팀에서 추방당했습니다.";
		teamDAO.dropList(team_idx, userId);
		teamDAO.sendNotice(msg, userId);
		return teamDAO.dropMember(team_idx, userId);
	}

	public int appliMember(int team_idx, String userId, int idx, int num) {
		String teamName = teamDAO.teamName(team_idx);
		String msg = "";
		logger.info(String.valueOf(idx));
		if (num == 1) {
			msg = teamName + " 팀 신청이 수락되었습니다.";
			teamDAO.updateStateYes(idx);
			teamDAO.intoTeam(team_idx, userId);
			teamDAO.sendNotice(msg, userId);
		} else {
			msg = teamName + " 팀 신청이 거부되었습니다.";
			teamDAO.updateStateNo(idx);
			teamDAO.sendNotice(msg, userId);
		}

		return 1;
	}

	public int delteWrite(int idx, int num) {
		int row = 0;
		if (num == 1) {
			// 팀원 모집글 삭제
			row = teamDAO.delTeamWrite(idx);
		} else {
			// 게스트 모집글 삭제
			row = teamDAO.delGuestWrite(idx);
		}

		return row;
	}

	public int destroyTeam(int team_idx, String id) {
		List<String> list = teamDAO.searchTeam(team_idx);
		String teamName = teamDAO.teamName(team_idx);
		String msg = teamName + " 팀이 해체되었습니다.";

		for (String user : list) {
			teamDAO.sendNotice(msg, user);
		}

		return teamDAO.destroyTeam(team_idx, id);
	}

	public int createComplete(MultipartFile photo, Map<String, String> param, String id) {
		int row = -1;

		TeamDTO dto = new TeamDTO();
		dto.setId(id);
		dto.setLogo(param.get("sitePhotos"));
		dto.setTeam_name(param.get("teamNikName"));
		dto.setTeam_address(param.get("address"));
		dto.setTeam_level(param.get("level"));
		dto.setTeam_info(param.get("teamDescription"));

		row = teamDAO.createComplete(dto);

		int idx = dto.getTeam_idx();
		logger.info("idx : {}", idx);

		if (row > 0) {
			row = teamDAO.insertTeamList(id, idx);
			fileSave(photo, idx, dto.getLogo());
		}

		return idx;
	}

	private void fileSave(MultipartFile photo, int idx, String logoName) {
		String newFileName = "team_logo" + idx;
		logger.info(newFileName);
		Path filePath = Paths.get(ROOT + newFileName + ".png");
		byte[] bytes;
		try {
			if (photo.getSize() == 0) {
				Path logoPath = Paths.get(ROOT + logoName + ".png");
				bytes = Files.readAllBytes(logoPath); // logoName 파일의 내용을 읽음
				logger.info("siteLogo filePath = " + logoPath + "siteLogo bytes = " + bytes.length);
			} else {
				bytes = photo.getBytes(); // photo의 내용을 읽음
				logger.info("uploadLogo filePath = " + filePath + "uploadLogo bytes = " + bytes.length);
			}
			Files.write(filePath, bytes);
			teamDAO.updateLogo(newFileName, idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
