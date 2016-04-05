package com.boot;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.model.ProjectManagement;
import com.service.ProjectMgmtService;
import com.service.ProjectMgmtServiceImpl;

public class BootClass {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProjectMgmtService projectMgmtService = new ProjectMgmtServiceImpl();
		
		Scanner scanner = new Scanner(System.in);
		String c =null;
		
		do{
			
			System.out.println("**************WELCOME*******************");
			System.out.println("1. Insert new record for project ");
			System.out.println("2. View all records ");
			System.out.println("3. Delete Record ");
			System.out.println("4. Search Record ");
			
			System.out.println("----------Please enter you choice :------------");
			int ch = scanner.nextInt();
			
			System.out.println(ch);
			
			switch(ch){
				case 1 : ProjectManagement projectManagement = new ProjectManagement();
				
						 System.out.println("Enter Project Id : ");
						 int prjId = scanner.nextInt();	
						 System.out.println("Enter Project name : ");
						 String prjName = scanner.next();
						 System.out.println("Enter Employee name : ");
						 String empName = scanner.next();
						 System.out.println("Enter Email Id : ");
						 String emailId = scanner.next();
						 System.out.println("Enter Department name : ");
						 String deptName = scanner.next();
						 System.out.println("Enter VNETNo : ");
						 String vNETNo = scanner.next();
						 System.out.println("Enter Mobile number : ");
						 int mobileNo = scanner.nextInt();
						 
						 projectManagement.setProjectId(prjId);
						 projectManagement.setProjectName(prjName);
						 projectManagement.setEmployeeName(empName);
						 projectManagement.setEmailId(emailId);
						 projectManagement.setDepartment(deptName);
						 projectManagement.setvNETNo(vNETNo);
						 projectManagement.setMobileNo(mobileNo);
						 
						 int result = projectMgmtService.insertRecord(projectManagement);
						 
						 System.out.println(result);
						 
						 break;
					
				case 2 : List<ProjectManagement> listAllRecords =  projectMgmtService.getAllRecords();
				
						 Iterator ite = listAllRecords.iterator();
						 
						 System.out.println("--------------------Details for all Projects----------------------");
						 
						 while(ite.hasNext()){
							 ProjectManagement management = new ProjectManagement();
							 management = (ProjectManagement) ite.next();
							
							 
							 System.out.println("Project Id : "+management.getProjectId());
							 System.out.println("Project Name : "+ management.getProjectName());
							 System.out.println("Employee Name : "+ management.getEmployeeName());
							 System.out.println("Email Id : "+ management.getEmailId());
							 System.out.println("VNETNo : "+ management.getvNETNo());
							 System.out.println("Department Name : "+ management.getDepartment());
							 System.out.println("Mobile No : "+ management.getMobileNo());
							 System.out.println("--------------------------------------------------------------");
						 }
						 
						 break;
					
				case 3 : int projectId = 0;
						 System.out.println("Enter the project code which you want to delete : ");
						 projectId = scanner.nextInt();
						 int deleteResult = projectMgmtService.deleteRecord(projectId); 
					
						 if(deleteResult == 1){
							 System.out.println("Record deleted sucessfully!!!");
						 }
						 else{
							 System.out.println("Record does not exists!!!!");
						 }
						 
						 break;
					
				case 4 : System.out.println("Please enter the Project id to be searched : ");
						 int pId = scanner.nextInt();
						 ProjectManagement prj = new ProjectManagement();
						 
						 prj = projectMgmtService.searchRecord(pId);
						 
						 System.out.println("--------------------------------------------------------------");
						 System.out.println("Project Id : "+prj.getProjectId());
						 System.out.println("Project Name : "+ prj.getProjectName());
						 System.out.println("Employee Name : "+ prj.getEmployeeName());
						 System.out.println("Email Id : "+ prj.getEmailId());
						 System.out.println("VNETNo : "+ prj.getvNETNo());
						 System.out.println("Department Name : "+ prj.getDepartment());
						 System.out.println("Mobile No : "+ prj.getMobileNo());
						 System.out.println("--------------------------------------------------------------");
						 
						 break;	
				
			}
			
			System.out.println("Do you want to continue ? (y/n)");
			c = scanner.next();
			
		}while(c.equals("y") || c.equals("Y"));	
		
		scanner.close();
	}

}
