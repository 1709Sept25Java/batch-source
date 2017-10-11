package com.revature.main;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.util.ConnectionUtil;

import com.revature.domain.*;

import com.revature.dao.*;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "connection.properties";
		Properties prop = new Properties();
		InputStream in;
		try {
			in = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");	
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement dept = con.prepareStatement("SELECT * FROM DEPARTMENTS WHERE DEPART_ID = ?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
