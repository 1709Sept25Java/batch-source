package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bank.DuplicateUsernameException;
import com.revature.connection.DatabaseConnection;
import com.revature.domain.User;

import oracle.jdbc.OracleTypes;

//AdminDao object is created from within Bank Session
//The menu options we get for admin are:
//		1. view users
//		2. create user
//		3. update user
//		4. delete user
//Note that both admin & customer dao use User objects
//Until admin logs out, the admin can keep choosing a menu option

public class AdminDaoImpl implements AdminDao {
	
	private int adminID;
	private Connection con;	
	private boolean login;
	private List<User> users;
	
	public AdminDaoImpl(Connection con, int id) {
		super();
		this.adminID = id;
		this.con = con;
		this.login = true;
		this.users = getUsers(); //We get users as part of constructutor 
	}

	public boolean loggedIn() {
		return login;
	}

	private void logout() {
		this.login = false;
	}
	
	//Session initiates and we keep admin logged in until they log out
	public void session() {
		System.out.println("Welcome admin");
		int option;
		//We use a do-while loop to keep admin logged in
		do {
			option = adminMenu(); //Get the command admin wants to run
			adminCommand(option); //Call the appropriate method
		} while (option!=4);
		
		
		logout(); //Once out of the do-while loop then we are "logged out"
	}
	
	//Controls the methods that are called based on admin input
	private void adminCommand(int option) {
		switch (option){
			case 0:
				viewUsers();
				break;
			case 1:
				try {
					createUser();
				} catch (Exception e) {
					e.printStackTrace(); //Reused exception from bank (register)
				}
				break;
			case 2:
				updateUser();
				break;
			case 3: 
				deleteUser();
				break;
		}
	}

	//The menu of option for the admin
	//Allow user input via console
	private static int adminMenu() {
		System.out.println("Admin menu");
		String[] options = {"View Users","Create User", "Update User", "Delete User","Logout"};
		Scanner sc = new Scanner(System.in);
		for (int i=0; i<options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
        System.out.print("Please choose an option: ");
        String input = sc.nextLine();
        return Integer.parseInt(input)-1;
	}
	
	//Method to view users
	//We also call view users under delete users to pick user to delete 
	public void viewUsers() {
		this.users = getUsers();
		System.out.printf("%-10s %-10s %-10s %-10s\n","","userid","username","usertype");
		for (int i=0; i<users.size(); i++) {
			System.out.printf("%-10s %-10s\n",(i+1),users.get(i).toString());
		}
	}
	
	//Returns a list of users, it is good to call it multiple times in case 
	//we created more users
	private ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		String viewUsers = "{call VIEW_USERS(?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(viewUsers);
			pstmt.setInt(1,this.adminID);
			pstmt.registerOutParameter(2, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(2);
			while(rs.next()){
				int userid = rs.getInt(1);
				String username = rs.getString(2);
				String usertype = rs.getString(3);
				User user = new User(userid, username, usertype);
				users.add(user);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	//Create user using user input from console
	public void createUser() throws DuplicateUsernameException{
		Scanner sc = new Scanner(System.in);
        System.out.println("Create User");
        System.out.print("Username: ");
        String un = sc.next();
        System.out.print("Password: ");
        String pw = sc.next();
        System.out.print("Choose: 1. Admin OR 2.Customer\n");
        int type = Integer.parseInt(sc.next());
        String t = (type==1)?"A":"C"; //ternary operator to map type of user
		String create = "{call CREATE_USER(?,?,?,?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.adminID);
			pstmt.setString(2, un);
			pstmt.setString(3, pw);
			pstmt.setString(4, t);
			pstmt.registerOutParameter(5, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			int result = pstmt.getInt(5);
			if (result==0) {
				System.out.println("User created!");
			}
			else {
				throw new DuplicateUsernameException("User with that username already exists!");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Admin can update user via console
	public void updateUser() {	
		Scanner sc = new Scanner(System.in);
		viewUsers();
        System.out.println("Select User to Delete");
        int option = Integer.parseInt(sc.next());
        int ui = users.get(option).getUserID();
        System.out.print("Username: ");
        String un = sc.next();
        System.out.print("Password: ");
        String pw = sc.next();
        System.out.print("Choose: 1. Admin OR 2.Customer\n");
        int type = Integer.parseInt(sc.next());
        String t = (type==1)?"A":"C"; //ternary operator to map type of user
		String create = "{call UPDATE_USER(?,?,?,?,?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.adminID);
			pstmt.setInt(2, ui);
			pstmt.setString(3, un);
			pstmt.setString(4, pw);
			pstmt.setString(5,t);
			pstmt.registerOutParameter(6, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			int result = pstmt.getInt(6);
			System.out.println(result);
			if (result>0) {
				System.out.println("User updated!");
			}
			else {
				System.out.println("User not updated"); //possible exception
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Admin can delete a user with basically no controls 
	//unlike customer that can only delete account if there is no balance
	public void deleteUser() {
		Scanner sc = new Scanner(System.in);
		viewUsers();
        System.out.println("Select User to Delete");
        int ui = Integer.parseInt(sc.next());
		String create = "{call DELETE_USER(?,?,?)}";
		CallableStatement pstmt;
		try {
			pstmt = this.con.prepareCall(create);
			pstmt.setInt(1,this.adminID);
			pstmt.setInt(2, ui);
			pstmt.registerOutParameter(3, OracleTypes.NUMBER);
			pstmt.executeUpdate();
			int result = pstmt.getInt(3);
			System.out.println(result);
			if (result>0) {
				System.out.println("User deleted!");
			}
			else {
				System.out.println("User not deleted"); //possible exception
			}		

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

}
