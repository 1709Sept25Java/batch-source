package revature.project2hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import java.io.*;
import java.sql.*;
import revature.project2hw.IncorrectPwException;

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
		this.user1 = user1;
	}

	public String getPw1() {
		return pw1;
	}

	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}
	
	public void userInput(){
		user= new ArrayList<User>();
		Scanner scan= new Scanner(System.in);
		
		System.out.println("Username: ");
		String u1=scan.nextLine();
		System.out.println("Password: ");
		String pw1=scan.nextLine();
		
		this.user1=u1;
		this.pw1=pw1;
	}
	
	public void checkUser() throws SQLException {
		Connection con=null;
		String user2=null; 
		//replace with function that calls driver manager
		try {
			//ManageConnection lg= new ManageConnection();
			con=ManageConnection.getConnectionFromFile();
			
			//test insert
			
			String selectSQL = "SELECT U_USERNAME FROM B_USER WHERE U_USERNAME="+"'"+user1+"'";
			PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery(selectSQL );
			ResultSetMetaData rms = rs.getMetaData();
			rms.getCatalogName(0);
			
			while (rs.next()) {
				user2 = rs.getString(1); 	
			}
			
			if(user2!=null) {
				//System.out.println("Welcome back "+user+ "!!!");
				//if successfully doesn't return null does get user
				//might have this do nothing for later till pw is typed in too, 
				//but always blocks login
				//then checks for pw
			}
			else{
				System.out.println("No username: "+user1+" Did you forget your UserName?");
			}
			
			//.out.println(con.getMetaData().getDriverName());
		} catch(Exception e){
			e.printStackTrace();
		}
		//prevent leaking the connection
		con.close();
	}
	
	public void checkPW() throws SQLException{
		Connection con2=null;
		String pw="";
		//get password---from user
		
		try {
			//ManageConnection lg= new ManageConnection();
			con2=ManageConnection.getConnectionFromFile();
			
			//U_PW is where pw is located
			String selectSQL = "SELECT U_PW FROM B_USER WHERE U_USERNAME= "
					+ ""+"'"+user1+"'"+" AND U_PW= " + "'"+pw1+"'";
			PreparedStatement preparedStatement = con2.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery(selectSQL );
			ResultSetMetaData rms = rs.getMetaData();

			while (rs.next()) {
				pw = rs.getString(1); 
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//if it doesn't succeeds in finding a password throws exception
		if (pw!="") {
		}
		else if(pw=="") {
			user1=null;
			pw1=null;
			try {
				throw new IncorrectPwException("Incorrect Pw");
			} catch (IncorrectPwException e) {
				System.out.println("Incorrect Password or User! Please Try Again.");
			}
		}
			
		con2.close();
	}
	
	public Boolean checkCredentials(String user, String pw) throws SQLException {
		Boolean loginSuccess=false;
		if (user1==null | (pw1==null)) {
			System.out.println("Login Failure!");
		}
		else if(user1!=null && pw1!=null)
		{
			System.out.println("Login Success! "+"Welcome "+user1+ "!");
			loginSuccess=true;
		}
		return loginSuccess;
	}
	
	public Boolean runCheckCredentials() throws SQLException {
		Boolean loginSuccess=false;
		userInput();
		checkUser();
		checkPW();
		if(checkCredentials(user1,pw1)) {
			loginSuccess=true;
		}
		//System.out.println("Success!");
		return loginSuccess;
	}

}
