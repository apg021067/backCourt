package com.back.official.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.back.official.service.OfficialService;

@Controller
public class OfficialController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired OfficialService officialService;
	
}
