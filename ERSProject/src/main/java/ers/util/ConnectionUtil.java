package ers.util;

import java.io.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.OracleDriver;

public class ConnectionUtil {
	
	private ConnectionUtil() {
		super();
	}
	
	private static ConnectionUtil obj = new ConnectionUtil();
	
	public static ConnectionUtil getinstance() {
		return obj;
	}
	
	private static String filename = "connection.properties";
	
	public static Connection getConnectionFromFile() throws IOException, SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Properties prop = new Properties();
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream in = classloader.getResourceAsStream("connection.properties");
		//InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
	
	public Connection establishedConnection() throws SQLException, IOException, ClassNotFoundException{
		Connection con = getConnectionFromFile();
		return con;
	}

}