package com.revature.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingleObject {
	private static SingleObject obj = new SingleObject();
	
	private SingleObject() {
		super();
	}
	
	public static SingleObject getInstance() {
		return obj;
	}
	
	
	
	public void counting() {
		for (int i=1; i<10; i++) {
			System.out.println(i);
		}
	}
	
	private static String filename = "connection.properties";
	
	public Connection establishDBConnection() throws IOException, SQLException {		
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");	
		return DriverManager.getConnection(url, username, password);
	}
	
	public void establishedConnection () throws SQLException, IOException {
		Connection con = establishDBConnection();
		System.out.println("Established Connection with Isolation level: " + con.getTransactionIsolation());
	}
}
