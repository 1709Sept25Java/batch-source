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

public class Bank {

	Connection con;
	
	public Bank() {
		super();
		con = DatabaseConnection.getConnection();
	}
	
	public void bankSession() {
		int option = startMenu(con);
		if (option==0) {
			User user = login(con);
			if (user!=null) {
				if (user.getUserType().equals("A")) {
					AdminDao admin = new AdminDaoImpl(con,user.getUserID());
					while (admin.loggedIn()) {
						admin.session();
					}
					try {
						this.con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					admin = null;
					System.out.println("Logged out");
				}
				else {
					CustomerDao customer = new CustomerDaoImpl(con, user.getUserID());
					while (customer.loggedIn()) {
						customer.session();
					}
					try {
						this.con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					customer = null;
					System.out.println("Logged out");
				}			
			}
		}
		else {
			register(con);
		}
	}
	

	public static int startMenu(Connection con) {
		System.out.println("Welcome");
		String[] menuOptions = {"Login","Register"};
		return userInput(menuOptions)-1;
	}
	
	public static ArrayList<String> startMenuInput(String option) {
		ArrayList<String> results = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
        System.out.println(option);
        System.out.print("Username: ");
        results.add(sc.next());
        System.out.print("Password: ");
        results.add(sc.next());
		return results;
	}
	
	
	

		
	public static void userMenu() {
		System.out.println("User menu");
		String[] options = {"Create Account", "View Accounts & Balances","Logout"};
		int option = userInput(options);
        System.out.println(option);

	}
	
	
	public static void accountMenu() {
		System.out.println("Account menu");
		String[] options = {"Deposit Account", "Withdraw Account", "Delete Account", "View Transactions","Logout"};
		int option = userInput(options);
        System.out.println(option);
	}
	
	public static int userInput(String[] options) {
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
        System.out.print("Please choose an option: ");
        String input = sc.nextLine();
        return Integer.parseInt(input);
	}
	
	public static User login(Connection con) {
		CallableStatement pstmt;
		ArrayList<String> results;
		ResultSet rs;
		int result;
		User user = null;
		String login = "{call LOGIN(?,?,?,?)}";
		try {
			results = startMenuInput("Login");
			pstmt = con.prepareCall(login);
			pstmt.setString(1, results.get(0));
			pstmt.setString(2, results.get(1));
			pstmt.registerOutParameter(3, OracleTypes.NUMBER);
			pstmt.registerOutParameter(4, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			result = pstmt.getInt(3);
//				result > 0 LOGIN SUCESS
//				result = 0 LOGIN FAIL
			if (result>0) {
				rs = (ResultSet) pstmt.getObject(4);
				while(rs.next()){
					int userid = rs.getInt(1);
					String usertype = rs.getString(2);
					user = new User(userid, usertype);
				}	
			}
			else {
				System.out.println("Not correct username or password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static void register(Connection con) {
		CallableStatement pstmt;
		ArrayList<String> results;
		int result;
		results = startMenuInput("Register");
		String register = "{call REGISTER_USER(?,?,?)}";
		try {
			pstmt = con.prepareCall(register);
			pstmt.setString(1, results.get(0));
			pstmt.setString(2, results.get(1));
			pstmt.registerOutParameter(3, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			result = pstmt.getInt(3);
			if (result==0) {
				System.out.println("Registered user successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
