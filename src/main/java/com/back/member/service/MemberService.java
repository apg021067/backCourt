package com.back.member.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.member.dao.MemberDAO;
import com.back.member.dto.MemberDTO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	MemberDAO memberDAO;

	public int Join(Map<String, String> param) {
		int row = memberDAO.Join(param);
		return row;
	}

	public Object overlay(String id) {
		return memberDAO.overlay(id);
	}

	/**
	 * id,pw 파라메터로 넣으면 유저 정보 MemberDTO 형태로 반환 
	 * @param String id
	 * @param String pw
	 * @return MemberDTO
	 */
	public MemberDTO getLoginInformation(String id, String pw) {
		return memberDAO.getLoginInformation(id, pw);
	}

}
