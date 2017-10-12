package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static String filename = "connection.properties";
	//This is EGREGIOUS don't do it
	//it hardcodes  your database credentials into your source code. 
	//tightly coupled and insecure
	public static Connection getConnection() throws SQLException{
		String url = "";
		String username ="";
		String password = "";
		return DriverManager.getConnection(url,username,password); 
	}
	//better way instead of hardcoding this
	public static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
} 

