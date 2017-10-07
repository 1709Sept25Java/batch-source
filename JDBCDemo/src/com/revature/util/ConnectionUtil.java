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
	
	//This is terrible don't do it - don't hard code credentials into source code.
	//Tightly coupled and insecure
	
	public static Connection getConnection() throws SQLException {
		String url = ""; //"jdbc:oracle:thin:@hostname:1521:ORCL"
		String username = "";
		String password = "";
		return DriverManager.getConnection(url,username,password); //where do we get our connection? Driver manager
	}
	
	//Better way 
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
