package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static String adminFile = "adminConnection.properties";
	private static String userFile = "userConnection.properties";

	public static Connection getAdminConnection() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(adminFile);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("pass");
		return DriverManager.getConnection(url, username, password);
	}
	
	public static Connection getUserConnection(String usernameEntered, String passwordEntered) throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(userFile);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("password");
		if (checkUser(usernameEntered, passwordEntered) == 0) {
			return DriverManager.getConnection(url, username, password);
		}
		if (checkUser(usernameEntered, passwordEntered) == 1) {
			System.out.println("Incorrect password");
			//login();
		}
		System.out.println("Username not registered");
		//login();
		return null;
	}
		
	public static int checkUser(String user, String pass) {
		return 0;
	}
}
