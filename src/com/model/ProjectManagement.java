package com.model;

public class ProjectManagement {

	private int projectId ;
	private String projectName;
	private String employeeName;
	private String emailId;
	private String department;
	private String vNETNo;
	private int mobileNo;
	
	@Override
	public String toString() {
		return "ProjectManagement [projectId=" + projectId + ", projectName="
				+ projectName + ", employeeName=" + employeeName + ", emailId="
				+ emailId + ", department=" + department + ", vNETNo=" + vNETNo
				+ ", mobileNo=" + mobileNo + "]";
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getvNETNo() {
		return vNETNo;
	}

	public void setvNETNo(String vNETNo) {
		this.vNETNo = vNETNo;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
	
}
