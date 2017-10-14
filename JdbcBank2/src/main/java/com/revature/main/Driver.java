package com.revature.main;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.Scanner;

import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.Users;
import com.revature.exception.InvalidUserException;

public class Driver {
	
	public static void main(String[] args) {
		
		//Start up welcome and menu
		System.out.println("Welcome to your friendly console bank!");
		System.out.println("Please select an option from the menu below:");
		System.out.println("\t 1) Log in to your account");
		System.out.println("\t 2) Create a new account");
		System.out.println("\t 3) Exit the console bank");
		
		//Retrieve user menu selection input
		Scanner sc = new Scanner(System.in);
		String select = sc.nextLine();
		int choice = Integer.parseInt(select);
		
		//Chose next action based on user menu choice
		switch (choice) {
		case 1:
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
			} catch (InvalidUserException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Create Account ");
			System.out.println("Username: ");
			String uname = sc.nextLine();
			System.out.println("Password: ");
			String passw = sc.nextLine();
			boolean create = new UsersDaoImpl().createUser(uname,passw,"f");
			System.out.println(create);
			break;
		case 3:
			System.out.println("Goodbye!");
			break;
		default:
			System.out.println("Not a menu option, please try again!");
		}
	}
	
	public static void login() {
		
	}

}
