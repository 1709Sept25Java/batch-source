package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static String file = "connection.properties";

	public static Connection GetConnectionFromFile() throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream(file);
		prop.load(input);
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pass = prop.getProperty("pass");
		return DriverManager.getConnection(url, user, pass);
	}
}
