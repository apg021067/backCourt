package com.back.court.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.back.court.service.CourtService;

@Controller
public class CourtController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	CourtService courtService;

	@RequestMapping(value = "/court/list.go")
	public String listGo() {
		logger.info("list.go /");
		return "court/list";
	}

	@RequestMapping(value = "/court/list.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> callList(HttpSession session, @RequestParam Map<String, Object> param) {
		logger.info("listCall / param = {} / ", param);
		logger.info("loginId = " + session.getAttribute("loginId"));
		param.put("id", session.getAttribute("loginId"));
		return courtService.list(param);

	}

	@RequestMapping(value = "/court/jjim.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> jjimAdd(HttpSession session, String courtIdx, HttpServletResponse response) {
		logger.info("jjimAdd / courtIdx = {}", courtIdx);
		String id = (String) session.getAttribute("loginId");
		if (id == null) {
			try {
				response.sendRedirect("/login.go");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("result", courtService.jjim(id, Integer.parseInt(courtIdx)));

		return map;
	}

	@RequestMapping(value = "/court/noJjim.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> jjimRemove(HttpSession session, String courtIdx) {
		logger.info("jjimAdd / courtIdx = {}", courtIdx);

		Map<String, Boolean> map = new HashMap<String, Boolean>();

//		세션 아이디 받아오
		String id = (String) session.getAttribute("loginId");
//		String id = "a";
		map.put("result", courtService.jjimRemove(id, Integer.parseInt(courtIdx)));

		return map;
	}

	@RequestMapping(value = "/court/detail.go")
	public String detailGo(HttpSession session, Model model, String court_idx) {
		String id = (String) session.getAttribute("loginId");
		if (id == null) {
			return "redirect:/login.go";
		}
		logger.info(court_idx);
		model.addAttribute("courtIdx", court_idx);
		return "court/detail";
	}

	@RequestMapping(value = "/court/detail.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> detail(String courtIdx, String selectDate) {
		logger.info("detail.ajax courtIdx = {}", courtIdx);
		return courtService.detail(courtIdx, selectDate);
	}

	@RequestMapping(value = "/court/booking.ajax", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> booking(HttpSession session, String courtStartTime, String courtIdx, String courtPrice,
			String courtDate) {
		String id = (String) session.getAttribute("loginId");

		return courtService.booking(courtStartTime, courtIdx, courtPrice, id, courtDate);
	}

}
