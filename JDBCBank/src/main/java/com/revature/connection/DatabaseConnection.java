package com.revature.connection;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {

	private static String filename = "connection.properties";
	
	private static Connection dbConnection;
	
	private DatabaseConnection() {
		super();
	}
	
	private static Connection getConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");	
		return DriverManager.getConnection(url,username,password);
	}

	public static Connection getConnection() {
		if (dbConnection == null) {
			try {
				dbConnection = getConnectionFromFile();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return dbConnection;
	}
}
	
	
