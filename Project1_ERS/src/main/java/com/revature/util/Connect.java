package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connect {

	public Connect() {
		super();
	}
	
	public static String file = "src/main/resources/connection.properties";
	
	public static Connection getConnection() throws SQLException, IOException {
		
		InputStream connect = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(connect);
		String url = prop.getProperty("url");
		String user = prop.getProperty("username");
		String password = prop.getProperty("pw");
		Connection c = DriverManager.getConnection(url, user, password);
		return c;
		
	};
	
	

}
