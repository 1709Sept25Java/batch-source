package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.*;


public class Driver {
	
	public static void main(String[] main) {
		
		/*
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		*/
		
		
		UsersDaoImpl udi = new UsersDaoImpl();
		System.out.println(udi.getRInfoById(15));
		
		
		
		
		
	}

}
