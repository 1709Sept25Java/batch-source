package revature.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import java.io.*;
import java.sql.*;

public class Login {	
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
		//testing connection
		String driver_db="jdbc:oracle:thin:";
		String hostname_db="@sept25java.c1tpw2p9yz97.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user_db="Admin";
		String pass_db="testing123";
		String test="Select FIRSTNAME from EMPLOYEE where EMPLOYEEID=0";
		
		Connection dbcon = null;

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


}
