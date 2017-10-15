package revature.project2hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateUserPass {
	

	public CreateUserPass(){
		super();
	}
	private String startName; 
	private String startPw;
	private String startUser;
	
	public String getStartName() {
		return startName;
	}
	
	public void setStartName(String startName) {
		this.startName=startName;
	}
	
	public String getStartUser() {
		return startUser;
	}
	
	public void setStartUser(String startUser) {
		this.startUser= startUser;
	}
	
	public String getStartPw() {
		return startPw;
	}

	public void setStartPw(String startPw) {
		this.startPw = startPw;
	}
	
	public void getUserInput() {
		//gets user input
		Scanner scan= new Scanner(System.in);
		System.out.println("Create an Account: \nYour name: ");
		String name1=scan.next();
		System.out.println("New Username: ");
		String user1=scan.next();
		System.out.println("New Password: ");
		String pw1=scan.next();
		
		startName=name1;
		startUser=user1;
		startPw=pw1;
	}
	
	public void insertAcc() throws SQLException {
		Connection con=null;
		
		//replace with function that calls driver manager
		try {
			ManageConnection lg= new ManageConnection();
			con=ManageConnection.getConnectionFromFile();
			
			//test insert
			
			String selectSQL = "INSERT into B_USER (U_NAME, U_PW, U_USERNAME) VALUES ("+"'"+startName+"',"+"'"+startPw+"',"+"'"+startUser+"')"; 
			PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery(selectSQL );
			ResultSetMetaData rms = rs.getMetaData();
			preparedStatement.executeUpdate();
			
			if(startUser!=null|startPw!=null) {
				System.out.println("Success! New Account\n"
						+ " User: "+ startUser +" Password: " +startPw
						+ "Welcome "+ startName+ "!");
				//if successfully doesn't return null, prints name out
				//might have this do nothing for later till pw is typed in too, 
				//but always blocks login
				//then checks for pw
			}
			else{
				System.out.println("Account Creation Failure!");
			}
			
			//.out.println(con.getMetaData().getDriverName());
		} catch(Exception e){
			e.printStackTrace();
		}
		//prevent leaking the connection
		con.close();
	}
	
	public Boolean checksIfAccExists() throws SQLException {
		Connection con=null;
		String createdUser=null;
		Boolean exists=false;
		try {
			ManageConnection lg= new ManageConnection();
			con=ManageConnection.getConnectionFromFile();
			
			String selectSQL = "SELECT U_USERNAME FROM B_USER WHERE U_USERNAME="+"'"+startUser+"'";
			PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery(selectSQL );
			ResultSetMetaData rms = rs.getMetaData();
			
			while (rs.next()) {
				createdUser = rs.getString(1); 	
			}
			
			if(createdUser!=null) {
				System.out.println("Username already taken");
				exists=true;
				//if taken, it exists
			}
		}
		catch(Exception e)	{
				e.printStackTrace();
			}
		return exists;
	}
	
	public void runCreateAcc() throws SQLException {
		getUserInput();
		//if user is not taken, will insert the account
		if(!checksIfAccExists()) {
			insertAcc();
		}
	}

	
}
