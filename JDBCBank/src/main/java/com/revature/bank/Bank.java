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
				if (user.getUserType().equals("A")) {
					AdminDao admin = new AdminDaoImpl(con,user.getUserID());
					while (admin.loggedIn()) {
						admin.session();
					}
					admin = null;
					System.out.println("Logged out");
				}
				else {
					CustomerDao customer = new CustomerDaoImpl(con, user.getUserID());
					while (customer.loggedIn()) {
						customer.session();
					}
					customer = null;
					System.out.println("Logged out");
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				register(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

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
	

	//Start menu
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
	
	//User input for login or register
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
