package com.revature.ConnectionUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public static String filename = "src/main/Connection.properties";
	
	public static Connection getConnection() throws SQLException, IOException {
		
		Properties p = new Properties();
		InputStream in = new FileInputStream(filename);
		p.load(in);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		return DriverManager.getConnection(url, username, password);
	}
	
	
	public static Connection getConnectionWithClassLoader() throws IOException, SQLException {
		
		Properties p = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		p.load(loader.getResourceAsStream(filename));
		String url = p.getProperty(p.getProperty("url"));
		String username = p.getProperty(p.getProperty("username"));
		String password = p.getProperty("password");
		return DriverManager.getConnection(url, username, password);
		
	}
	
}
