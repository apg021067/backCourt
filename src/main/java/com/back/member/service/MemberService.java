package com.back.member.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.member.dao.MemberDAO;

@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired MemberDAO memberDAO;
	
}
