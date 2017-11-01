package com.revaturedao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionDB {
	
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException, ClassNotFoundException {
		Properties prop = new Properties();
		prop.load(ConnectionDB.class.getResourceAsStream(filename));
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, username, password);

	}
}
