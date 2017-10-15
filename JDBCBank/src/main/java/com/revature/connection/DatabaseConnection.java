package com.revature.connection;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {

	//Private Variables for Singleton Database Connection
	private static String filename = "connection.properties";
	
	private static Connection dbConnection;
	
	private DatabaseConnection() {
		super();
	}
	
	//Create connection to Database
	private static Connection getConnectionFromFile() {
		//Initialize variables
		Properties prop;
		InputStream in;
		String url = "";
		String username = "";
		String password = "";
		Connection con = null;
		//Try to retrieve values from properties file
		try { 
			prop = new Properties();
			in = new FileInputStream(filename);
			prop.load(in);
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");	
		} catch (IOException i) {
			i.printStackTrace();
		}
		//Try to establish database connection
		try {
			con =  DriverManager.getConnection(url,username,password);
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return con;
	}

	//Get Database Instance Method 
	public static Connection getConnection() {
		//If there is no connection we will try to establish a connection
		if (dbConnection == null) {
			dbConnection = getConnectionFromFile();	
		}
		//Else we return already existing connection
		return dbConnection;
	}
}
	
	
