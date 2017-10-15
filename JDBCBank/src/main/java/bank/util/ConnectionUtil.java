package bank.util;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectionUtil {
	
	private ConnectionUtil() {
		super();
	}
	
	private static ConnectionUtil obj = new ConnectionUtil();
	
	public static ConnectionUtil getinstance() {
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