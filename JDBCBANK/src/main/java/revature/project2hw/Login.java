package revature.project2hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import java.io.*;
import java.sql.*;

public class Login{	
	Login(){
		super();
	}
	
	private String user1;
	private String pw1;
	
	List<User> user;
	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		//concatenate Strings for SQL syntax
		this.user1 = "'"+user1+"'";
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = "'"+pw1+"'";
	}
	
	public void userInput(){
		user= new ArrayList<User>();
		Scanner scan= new Scanner(System.in);
		
		System.out.println("Username: ");
		this.user1=scan.nextLine();
		System.out.println("Password: ");
		this.pw1=scan.nextLine();
	}
	
	public String checkUser() throws SQLException {
		Connection con=null;
		String fname=null, lname=null;
		//replace with function that calls driver manager
		try {
			ManageConnection lg= new ManageConnection();
			con=ManageConnection.getConnectionFromFile();
			
			//test insert
			this.user1="'Andrew'";
			
			String selectSQL = "SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE WHERE FIRSTNAME="+this.user1;
			PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery(selectSQL );
			ResultSetMetaData rms = rs.getMetaData();
			rms.getCatalogName(0);
			
			while (rs.next()) {
				fname = rs.getString(1); 
				lname = rs.getString(2);
				
			}
			if(fname!=null|lname!=null) {
				System.out.println(fname +" " +lname);
				//if successfully doesn't return null, prints name out
				//might have this do nothing for later till pw is typed in too, 
				//but always blocks login
				//then checks for pw
			}
			else{
				System.out.println("Did you forget your name?");
			}
			
			//.out.println(con.getMetaData().getDriverName());
		} catch(Exception e){
			e.printStackTrace();
		}
		//prevent leaking the connection
		con.close();
		String fullname= fname;
		return fullname;
	}
	
	public String checkPW(String user) throws SQLException{
		Connection con2=null;
		String pw="";
		user=this.user1;
		//get password
		String selectSQL = "SELECT LASTNAME FROM EMPLOYEE WHERE ="+this.user1 +" FIRSTNAME";
		PreparedStatement preparedStatement = con2.prepareStatement(selectSQL);
		ResultSet rs = preparedStatement.executeQuery(selectSQL );
		ResultSetMetaData rms = rs.getMetaData();
		
		while (rs.next()) {
			pw = rs.getString(1); 	
		}
		
		try {
			ManageConnection lg= new ManageConnection();
			con2=ManageConnection.getConnectionFromFile();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(pw);
		
		con2.close();
		
		return pw;
	}
	
	public void checkCredentials(String user, String pw) throws SQLException {
		if ((checkPW(this.user1)==null) || (checkUser()==null)) {
			System.out.println("Login Failure!");
		}
		else if((checkPW(this.user1)!=null) && (checkUser()!=null))
		{
			System.out.println("Login Success! "+"Welcome "+this.user1);
		}
	}

}
