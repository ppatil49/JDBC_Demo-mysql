package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.dbutil.DBUtil;
import com.model.ProjectManagement;


public class ProjectMgmtRepositoryImpl extends DBUtil implements ProjectMgmtRepository {

	Connection con = null;
	PreparedStatement stmt = null;
	
	public ProjectMgmtRepositoryImpl(){
		/*con = getDBConnect();*/
	}
	
	
	public List<ProjectManagement> getAllRecords(){
		
		con = getDBConnect();
		List<ProjectManagement> listAll = new ArrayList<ProjectManagement>();
		
		try{
			stmt = con.prepareStatement("select * from Project_Management");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				ProjectManagement projectManagement = new ProjectManagement();
				
				projectManagement.setProjectId(rs.getInt("ProjectId"));
				projectManagement.setProjectName(rs.getString("ProjectName"));
				projectManagement.setEmployeeName(rs.getString("EmployeeName"));
				projectManagement.setEmailId(rs.getString("EmailId"));
				projectManagement.setvNETNo(rs.getString("VNETNo"));
				projectManagement.setDepartment(rs.getString("Deparment"));
				projectManagement.setMobileNo(rs.getInt("MobileNo"));
				
				listAll.add(projectManagement);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listAll;
	}
	
	
	public int insertRecord(ProjectManagement projectManagement){
		
		con = getDBConnect();
		int rs= 0 ;
		try{
			String insertTableSQL = "INSERT INTO Project_Management"
					+ "(ProjectId, ProjectName, EmployeeName, EmailId,VNETNo,Deparment,MobileNo) VALUES"
					+ "(?,?,?,?,?,?,?)";
			
			stmt = con.prepareStatement(insertTableSQL);
			
			stmt.setInt(1, projectManagement.getProjectId());
			stmt.setString(2, projectManagement.getProjectName());
			stmt.setString(3, projectManagement.getEmployeeName());
			stmt.setString(4, projectManagement.getEmailId());
			stmt.setString(5, projectManagement.getvNETNo());
			stmt.setString(6, projectManagement.getDepartment());
			stmt.setInt(7, projectManagement.getMobileNo());
			
			rs = stmt.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public int deleteRecord(int projectId){
		
		int rs = 0;
		con = getDBConnect();
		
		try{
			String deleteSQL = "DELETE from Project_Management WHERE ProjectId = ?";
			stmt = con.prepareStatement(deleteSQL);
			stmt.setInt(1, projectId);
			rs = stmt.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return rs;
	}
	
	public ProjectManagement searchRecord(int projectId){
		
		con = getDBConnect();
		ProjectManagement management = new ProjectManagement();
		
		try{
			String sql = "select * from Project_Management WHERE ProjectId = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, projectId);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				management.setProjectId(rs.getInt("ProjectId"));
				management.setProjectName(rs.getString("ProjectName"));
				management.setEmployeeName(rs.getString("EmployeeName"));
				management.setEmailId(rs.getString("EmailId"));
				management.setvNETNo(rs.getString("VNETNo"));
				management.setDepartment(rs.getString("Deparment"));
				management.setMobileNo(rs.getInt("MobileNo"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return management;
	}
}
