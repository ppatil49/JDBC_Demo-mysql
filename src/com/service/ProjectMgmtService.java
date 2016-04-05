package com.service;

import java.util.List;

import com.model.ProjectManagement;

public interface ProjectMgmtService {

	public int insertRecord(ProjectManagement projectManagement);
	
	public List<ProjectManagement> getAllRecords();
	
	public int deleteRecord(int projectId);
	
	public ProjectManagement searchRecord(int projectId);
}
