package com.dao;

import java.util.List;

import com.model.ProjectManagement;

public interface ProjectMgmtRepository {

	public int insertRecord(ProjectManagement projectManagement);
	
	public List<ProjectManagement> getAllRecords();
	
	public int deleteRecord(int projectId);
	
	public ProjectManagement searchRecord(int projectId);
}
