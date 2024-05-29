package com.back.member.dao;

import java.util.Map;

import com.back.member.dto.MemberDTO;

public interface MemberDAO {

	int Join(Map<String, String> param);

	int overlay(String id);

	MemberDTO getLoginInformation(String id, String pw);

}
