package com.revature.main;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Util {

	public static Connection getJDBCConnection() throws SQLException, IOException {
		//Sstem.out.println(new File(".").getAbsoluteFile());
		Properties prop = new Properties();
		//InputStream in = new FileInputStream("Connection.properties");
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream in = classloader.getResourceAsStream("Connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String pass = prop.getProperty("pass");
		DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String dateString = dateFormat.format(date);	
		return dateString;
	}
	
	
}
