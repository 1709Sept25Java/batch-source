package com.revature.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DriverClass {

	public static void main(String[] args) {
		Connection con;
		try {
			con = ConnectionClass.getConnectionFromFile("connection.properties");
			System.out.println(con.getMetaData().getDriverName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getDepartmentData() {
		PreparedStatement getDepName = null;
		PreparedStatement getDepAvgSalary = null;
		
		
	}
}
