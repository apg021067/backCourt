package com.back.header.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.header.dao.HeaderDAO;

@Service
public class HeaderService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired HeaderDAO headerdao;
	
}
