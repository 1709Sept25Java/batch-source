package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.connection.DatabaseConnection;
import com.revature.dao.*;
import com.revature.domain.*;

import oracle.jdbc.OracleTypes;

//Bank Class controls a session to bank and allows us to logout
//We get a database connection only after having logged in as either an admin or client
//There are methods that call for user input
public class Bank {

	private Connection con;

	//The bank object has a connection to database that will be passed to 
	//DAO objects - there's only one connection to the database
	public Bank() {
		super();
		con = DatabaseConnection.getConnection();
	}
	
	public void bankSession() {
		//Get command to login or register
		int option = startMenu(con);
		if (option==0) {
			try {
				//Login as admin or customer
				//While logged in variable is true, we keep going back to admin or customer menu
				//When not logged in, we set AdminDao or CustomerDao to null
				User user = login(con);
				if (user.getUserType().equals("A")) { //Check what kind of user
					AdminDao admin = new AdminDaoImpl(con,user.getUserID());
					while (admin.loggedIn()) { //While loop ends as soon as adminDao "logs out"
						admin.session();
					}
					this.con.close(); //Close connection to database
					admin = null; //Set admin dao to null as a "log out" mechanism
									//We will no longer be able to use admin.viewusers, admin.createuser, etc
					System.out.println("Logged out");
				}
				else {
					CustomerDao customer = new CustomerDaoImpl(con, user.getUserID());
					while (customer.loggedIn()) {
						customer.session();
					}
					this.con.close(); //Close connection to database
					customer = null; //Set customer dao to null as a "log out" mechanism
										//We will no longer be able to user customer dao methods 
											//and also including account dao & transaction dao methods
					System.out.println("Logged out");
				}	
			} catch (Exception e) {
				//User not found exception
				e.printStackTrace();
			}
		}
		else {
			try {
				register(con);
			} catch (Exception e) {
				//Duplicate username exception
				//The main reason for registration failure 
				//should be an already existing user with that username
				e.printStackTrace();
			}
		}
	}

	//Login using Database connection passed from session method
	//We retrieve a user object if login is successful
	//int result is 1 if a user is created 
	//else no user was found and we throw UserNotFoundException
	public static User login(Connection con) throws SQLException, UserNotFoundException {
		CallableStatement pstmt;
		ArrayList<String> results;
		ResultSet rs;
		int result;
		User user = null;
		String login = "{call LOGIN(?,?,?,?)}";
		results = loginOrRegisterInput("Login");
		pstmt = con.prepareCall(login);
		pstmt.setString(1, results.get(0));
		pstmt.setString(2, results.get(1));
		pstmt.registerOutParameter(3, OracleTypes.NUMBER);
		pstmt.registerOutParameter(4, OracleTypes.CURSOR);
		pstmt.executeUpdate();
		result = pstmt.getInt(3);
		/* Database based meanings of variables 
			result > 0 LOGIN SUCESS
			result = 0 LOGIN FAIL 
		*/
		if (result>0) {
			rs = (ResultSet) pstmt.getObject(4);
			while(rs.next()){
				int userid = rs.getInt(1);
				String usertype = rs.getString(2);
				user = new User(userid, usertype);
			}	
		}
		else {
			throw new UserNotFoundException("User not found: invalid username or password");
		}
		return user;
	}
	
	//Login using Database connection passed from session method
		//We create a user object if username is not created
		//int result is 0 if user doesn't exist and we make the user 
		//else a user was found and we throw a duplicate username exception
	public static void register(Connection con) throws SQLException, DuplicateUsernameException {
		CallableStatement pstmt;
		ArrayList<String> results;
		int result;
		results = loginOrRegisterInput("Register");
		String register = "{call REGISTER_USER(?,?,?)}";
		pstmt = con.prepareCall(register);
		pstmt.setString(1, results.get(0));
		pstmt.setString(2, results.get(1));
		pstmt.registerOutParameter(3, OracleTypes.NUMBER);
		pstmt.executeUpdate();
		result = pstmt.getInt(3);
		/* Database based meanings of variables 
		result = 0 REGISTER SUCESS
		result > 0 LOGIN FAIL 
		*/
		if (result==0) {
			System.out.println("Registered user successfully!");
		}
		else {
			throw new DuplicateUsernameException("User not registered");
		}
	}
	

	//Start menu: The two initial options
	//login or register
	//Ask for user input from console
	//Future: validate input
	public static int startMenu(Connection con) {
		System.out.println("Welcome");
		String[] options = {"Login","Register"};
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
        System.out.print("Please choose an option: ");
        String input = sc.nextLine();
        return Integer.parseInt(input) -1 ;
	}
	
	//User input for login or register methods
	//We ask for username and password
	public static ArrayList<String> loginOrRegisterInput(String option) {
		ArrayList<String> results = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
        System.out.println(option);
        System.out.print("Username: ");
        results.add(sc.next());
        System.out.print("Password: ");
        results.add(sc.next());
		return results;
	}
}
