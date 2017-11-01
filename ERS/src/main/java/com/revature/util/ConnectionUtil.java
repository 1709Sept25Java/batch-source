package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class ConnectionUtil {
	
	private static String filename = "/Users/massielpimentel/1709Sept25Java/batch-source/ERS/connection.properties";
	
	
	
	public static Connection getConnectionFromFile() throws IOException, SQLException{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return (Connection) DriverManager.getConnection(url,username,password);
		
	}

}
