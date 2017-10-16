package com.revature.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.dao.LoginDaoImpl;
import com.revature.dao.SuperUserDaoImpl;

public class SuperUser extends User{
	
	private static Scanner scan;

	public SuperUser(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public static void options(Connection con) throws SQLException, IOException {
		System.out.println("Please enter the number corresponding to your request:");
		System.out.println("1 - View user(s)");
		System.out.println("2 - Create new user");
		System.out.println("3 - Update user");
		System.out.println("4 - Delete user(s)");
		System.out.println("5 - Log out");
		scan = new Scanner(System.in);
		switch (scan.next()) {
		case "1":
			SuperUserDaoImpl.viewUser(con);
			break;
		case "2":
			SuperUserDaoImpl.createNewUser(con);
			break;
		case "3":
			SuperUserDaoImpl.updateUser(con);
			break;
		case "4":
			SuperUserDaoImpl.deleteUser(con);
			break;
		case "5":
			LoginDaoImpl.Logout(con);
			break;
		default:
			System.out.println("Invalid entry");
			options(con);
		}
	}

	
	public void viewUser(User userObj) {
		System.out.println("Username: "+userObj.getUsername());
		System.out.println("Password: "+userObj.getPassword());
		
	}
	
	public void viewAll() {
		
	}
}