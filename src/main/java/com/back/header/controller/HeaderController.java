package com.back.header.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.back.header.service.HeaderService;

@Controller
public class HeaderController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired HeaderService headerserivce;
	
	@RequestMapping(value = "/header")
	public String header() {
		return "header/header";
	}
	
}
