package com.revature.main;

import java.util.Scanner;

import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.Users;
import com.revature.exception.InvalidUserException;
import com.revature.exception.PasswordMismatchException;
import com.revature.exception.UserNotCreatedException;

public class Driver {
	
	public static void main(String[] args) {
		
		//Start up welcome and menu
		System.out.println("Welcome to the First Intergalactic Bank of Prosper!");
		System.out.println("Please select an option from the menu below:");
		System.out.println("\t 1) Log in to your account");
		System.out.println("\t 2) Create a new account");
		System.out.println("\t 3) Exit the console bank");
		
		//Retrieve user menu selection input
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		int choice = Integer.parseInt(select);
		//sc.close();
		
		//Chose next action based on user menu choice
		switch (choice) {
		case 1:
			login(sc);
			break;
		case 2:
			try {
				createUser(sc);
			} catch (PasswordMismatchException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("Goodbye!");
			break;
		default:
			System.out.println("Not a menu option!");
			System.out.println("Goodbye!");
		}
		sc.close();
	}
	
	public static void login(Scanner sc) {
		System.out.println("Login ");
		
		//Get user name and password through console input
		System.out.println("Username: ");
		String username = sc.nextLine();
		System.out.println("Password: ");
		String pw = sc.nextLine();
		
		//Get user from database
		UsersDao accessUsers = new UsersDaoImpl();
		try {
			Users user = accessUsers.login(username, pw);
			System.out.println(user);
			if(!user.isAdmin()) {
				UserSession.userSession(user);
			} else {
				UserSession.adminSession(user);
			}
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
	
	public static void createUser(Scanner sc) throws PasswordMismatchException {
		UsersDao accessUsers = new UsersDaoImpl();
		
		//Have the user set the username and password for their new account
		System.out.println("Create Account ");
		System.out.println("Username: ");
		String uname = sc.nextLine();
		System.out.println("Password: ");
		String pw = sc.nextLine();
		System.out.println("Verify password: ");
		String pwCheck = sc.nextLine();
		
		//Throw an exception if the password does not match
		if(!pw.equals(pwCheck)) {
			throw new PasswordMismatchException();
		}
		
		//Try to insert a new user into the database
		boolean create;
		try {
			create = accessUsers.createUser(uname,pw,"f");
			System.out.println("Please login: ");
			//Call the login function if the user is successfully inserted
			if(create) {
				login(sc);
			}
			
		} catch (UserNotCreatedException e) {
			e.printStackTrace();
		}
		createUser(sc);
	}

}
