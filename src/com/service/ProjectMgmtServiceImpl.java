package com.service;

import java.util.List;

import com.dao.ProjectMgmtRepositoryImpl;
import com.model.ProjectManagement;

public class ProjectMgmtServiceImpl implements ProjectMgmtService{

	ProjectMgmtRepositoryImpl mgmtRepository = new ProjectMgmtRepositoryImpl();
	
	public List<ProjectManagement> getAllRecords(){
		
		return mgmtRepository.getAllRecords();
	}
	
	public int insertRecord(ProjectManagement projectManagement){
		
		return mgmtRepository.insertRecord(projectManagement);
	}
	
	public int deleteRecord(int projectId){
		return mgmtRepository.deleteRecord(projectId);
	}
	
	public ProjectManagement searchRecord(int projectId){
		return mgmtRepository.searchRecord(projectId);
	}
}
