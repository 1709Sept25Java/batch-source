package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static String filename = "connection.properties";
	
	private ConnectionUtil() {};
	
	private static ConnectionUtil connU;
	private static Connection conn;
	
	public static ConnectionUtil getInstance() {
		if(connU == null) {
			connU = new ConnectionUtil();
		}
		
		return connU;
	}
	
	private Connection getConnection() throws IOException, SQLException{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream(filename));
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		return DriverManager.getConnection(url,username,password);
	}
	
	public Connection getConnected() throws IOException, SQLException {
		if(conn == null){
			conn = this.getConnection();
		}
		
		return conn;
	}
	
}
