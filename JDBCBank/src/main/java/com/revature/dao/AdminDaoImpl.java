package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.connection.DatabaseConnection;
import com.revature.domain.User;

import oracle.jdbc.OracleTypes;

public class AdminDaoImpl implements AdminDao {
	
	int adminID;
	Connection con;	
	boolean login;
	List<User> users;
	
	public AdminDaoImpl(Connection con, int id) {
		super();
		this.adminID = id;
		this.con = con;
		this.login = true;
		this.users = getUsers();
	}

	public boolean loggedIn() {
		return login;
	}

	public void logout() {
		this.login = false;
	}
	
	public void session() {
		System.out.println("Welcome admin");
		int option;
		do {
			option = adminMenu();
			adminCommand(option);
		} while (option!=4);
		
		
		logout();
	}
	
	private void adminCommand(int option) {
		switch (option){
			case 0:
				viewUsers();
				break;
			case 1:
				createUser();
				break;
			case 2:
				updateUser();
				break;
			case 3: 
				deleteUser();
				break;
		}
	}

	public static int adminMenu() {
		System.out.println("Admin menu");
		String[] options = {"View Users","Create User", "Update User", "Delete User","Logout"};
		return userInput(options)-1;
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
	
	public void viewUsers() {
		this.users = getUsers();
		for (int i=0; i<users.size(); i++) {
			System.out.println((i+1)+'\t'+users.get(i).toString());
		}
	}
	
	public ArrayList<User> getUsers() {
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

	public void createUser() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Create User");
        System.out.print("Username: ");
        String un = sc.next();
        System.out.print("Password: ");
        String pw = sc.next();
        System.out.print("Choose:\n\t1. Admin\n\t2.Customer\n");
        int type = Integer.parseInt(sc.next());
        String t = (type==1)?"A":"C";
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
				System.out.println("Username already taken");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


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
        System.out.print("Chose:1. Admin\2.Customer");
        int type = Integer.parseInt(sc.next());
        String t = (type==1)?"A":"C";
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
				System.out.println("User not updated");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
				System.out.println("User not deleted");
			}		

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	

}
