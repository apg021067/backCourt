package com.back.admin.dao;

import java.util.List;
import java.util.Map;

import com.back.admin.dto.AdminReportDTO;

public interface AdminReportDAO {

	AdminReportDTO detail(String reportIdx);

	int totalPage(Map<String, Object> param);

	List<AdminReportDTO> list(Map<String, Object> param);

	boolean update(Map<String, String> param);

	boolean feedInsert(Map<String, String> param);

	boolean noticeInsert(Map<String, String> param);

}
