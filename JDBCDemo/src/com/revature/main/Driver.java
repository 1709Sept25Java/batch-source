package com.revature.main;
import java.sql.Connection;

import revature.com.util.ConnectionUtil;


public class Driver {

	public static void main(String[] args) {
		 		
		 		//Connection con = "jdbc:oracle:thin:@sep25th.cp2srkevez4s.us-east-2.rds.amazonaws.com:1521:ORCL";
		 		Connection con = null;
		 		try {
		 		con = ConnectionUtil.getConnectionFromFile("connection.properties");
		 			System.out.println(con.getMetaData().getDriverName());
		 		} catch(Exception e){
		 			e.printStackTrace();
		 		}
		 		
		 		
		 
		 	}
}
