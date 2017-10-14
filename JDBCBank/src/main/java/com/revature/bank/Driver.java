package com.revature.bank;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import com.revature.connection.DatabaseConnection;
import com.revature.dao.*;

import oracle.jdbc.OracleTypes;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws SQLException {
//		Connection con = DatabaseConnection.getConnection();
//		//Function
//		CallableStatement stmt = con.prepareCall("{? = call LOGIN(?, ?)}");
//		stmt.registerOutParameter(1, Types.INTEGER);
//		stmt.setString(2,"Jenny");       
//		stmt.setString(3,"jenny*");
//		stmt.execute(); 
//		int output = stmt.getInt(1);
//		System.out.println(output);
//		
//		//Procedure
//		int id = 5105;
//		String viewUsers = "{call VIEW_USERS(?,?)}";
//		CallableStatement pstmt = con.prepareCall(viewUsers);
//		pstmt.setInt(1,id);
//		pstmt.registerOutParameter(2, OracleTypes.CURSOR);
//		pstmt.executeUpdate();
//		ResultSet rs = (ResultSet) pstmt.getObject(2);
//		while(rs.next()){
//			int userid = rs.getInt(1);
//			String username = rs.getString(2);
//			String usertype = rs.getString(3);
//			System.out.println(userid+" \t"+username+" \t"+usertype);
//		}
		//Register
//		String registerUser = "{call REGISTER_USER(?,?)}";
//		CallableStatement pstmt = con.prepareCall(registerUser);
//		pstmt.setString(1, "Minnie");
//		pstmt.setString(2, "mouse");
//
//		pstmt.executeUpdate();
		//https://www.mkyong.com/jdbc/jdbc-callablestatement-stored-procedure-out-parameter-example/
		//https://stackoverflow.com/questions/19333011/how-to-call-a-stored-function-from-jdbc
//		int option = initialMenu();
//		System.out.println(option);
//		loginOrRegister(con, option-1);
//		ADMIN
	AdminDao admin = new AdminDaoImpl(5105);
		admin.viewUsers();
		
		//admin.createUser("Admin2", "minnie", "A");
		
//		admin.updateUser(5225, "Admin2", "hello", "A");
		
//		admin.deleteUser(5220);
		//admin = null; //my mock logout?
		
//		UserDao user = new UserDaoImpl(con,5020);
//		user.viewTransactions();
//		user.createAccount("Checking", 1000);
//		user.viewAccounts();
//		
		//AccountDao account = new AccountDaoImpl(con, 7280);
//		account.depositAccount(25);
//		account.withdrawAccount(10);
		//account.withdrawAccount(1045);
		
	//	System.out.println( account.deleteAccount() );
		
	//	con.close();
		
	}

	public static int initialMenu() {
		System.out.println("Welcome to the bank!");
		String[] options = {"Login","Register"};
		int option = userInput(options);
        return option;
	}
	
	public static ArrayList<String> initialMenuInput(int option, String queryOption) {
		ArrayList<String> results = new ArrayList<String>();
		
		Scanner sc = new Scanner(System.in);
		
		switch (option) {
			case 0: 
		        System.out.println("LOGIN");
		        System.out.println("Username: ");
		        results.add(sc.next());
		        System.out.println("Password: ");
		        results.add(sc.next());
				break;
				
			case 1: 
				 System.out.println("REGISTER");
				 System.out.println("Username: ");			
			     results.add(sc.next());
				 System.out.println("Password: ");
			     results.add(sc.next());
				 break;
			
			default:System.out.println("No valid input given");
		}
		return results;
	}
	

	public static void adminMenu() {
		System.out.println("Admin menu");
		String[] options = {"View Users","Create User", "Update User", "Delete User","Logout"};
		int option = userInput(options);
        System.out.println(option);

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
		
        System.out.println("Please choose an option: ");
        
        String input = sc.nextLine();
        
        return Integer.parseInt(input);
	}
	
	public static void loginOrRegister(Connection con, int option) throws SQLException {
		ArrayList<String> results = new ArrayList<String>();
		switch (option) {
			case 0: 
				CallableStatement stmt = con.prepareCall("{? = call LOGIN(?, ?)}");
				stmt.registerOutParameter(1, Types.INTEGER);
				results = initialMenuInput(option, "Login");
				stmt.setString(2, results.get(0));       
				stmt.setString(3,results.get(1));
				stmt.execute(); 
				int output = stmt.getInt(1);
				System.out.println(output);
				break;
			case 1: 
				results = initialMenuInput(option, "Register");
				String registerUser = "{call REGISTER_USER(?,?)}";
				CallableStatement pstmt = con.prepareCall(registerUser);
				pstmt.setString(1, results.get(0));
				pstmt.setString(2, results.get(1));
				System.out.println(pstmt.executeUpdate());
				
				break;
			default:
				System.out.println("No valid input given!");			
		}	
	}
}



