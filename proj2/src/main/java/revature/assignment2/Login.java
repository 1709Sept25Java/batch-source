package revature.assignment2;

import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class Login {	
	
	private static String filename = "connection.properties";
	
	Login(){
		super();
	}
	
	private String user;
	private String pw;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw=pw;
	}
	
	public void userInput(){	
		Scanner scan= new Scanner(System.in);
		System.out.println("Username: ");
		this.user=scan.nextLine();
		System.out.println("Password: ");
		this.pw=scan.nextLine();
	}
	
	public void fillUserTable() throws SQLException, IOException{
		//singleton
		
		String driver_db="jdbc:oracle:thin:";
		String hostname_db="@sept25java.c1tpw2p9yz97.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user_db="Admin";
		String pass_db="testing123";
		String test="Select FIRSTNAME from EMPLOYEE where EMPLOYEEID=0";
		
		Connection dbcon = null;
		//get inputstream from connection.properties
		//dbcon=ConnectionUtil.getConnectionFromFile();
		
		//get stored procedure from callable statement
			try {	
			dbcon=DriverManager.getConnection(driver_db+ hostname_db, user_db, pass_db);
			PreparedStatement ps= dbcon.prepareStatement(test);
			ResultSet rs= ps.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();
			
			//close connection
			System.out.println();
			dbcon.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	public static Connection getConnectionFromFile() throws IOException, SQLException{
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}

}
