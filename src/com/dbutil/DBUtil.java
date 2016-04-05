package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public Connection getDBConnect(){
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_Demo","root","root");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
