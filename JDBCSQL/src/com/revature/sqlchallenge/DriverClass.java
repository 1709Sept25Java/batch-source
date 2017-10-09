package com.revature.sqlchallenge;

import java.sql.Connection;

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
}
