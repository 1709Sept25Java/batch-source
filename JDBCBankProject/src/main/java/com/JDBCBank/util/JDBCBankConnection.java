package com.JDBCBank.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCBankConnection {
	private JDBCBankConnection() {
		super();
	}
	private static JDBCBankConnection obj = new 	JDBCBankConnection();
	public static JDBCBankConnection getinstance() {
		return obj;
	}
	
private static String filename = "connection.properties";

public static Connection getConnectionFromFile() throws IOException, SQLException{
	Properties prop = new Properties();
	InputStream in = new FileInputStream(filename);
	prop.load(in);
	String url = prop.getProperty("url");
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");
	return DriverManager.getConnection(url,username,password);
	}
public Connection establishedConnection() throws SQLException, IOException{
	Connection con = getConnectionFromFile();
	return con;
}


}
