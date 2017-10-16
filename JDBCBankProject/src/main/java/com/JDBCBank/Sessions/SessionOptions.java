package com.JDBCBank.Sessions;

import java.util.Scanner;

import com.JDBCBank.DAO.UsersDao;
import com.JDBCBank.DAO.UserDaoImpl;
import com.JDBCBank.domain.Users;
import com.JDBCBank.exceptions.InvalidPasswordException;
import com.JDBCBank.exceptions.UserDoesNotExistException;
import com.JDBCBank.main.Driver;
import com.JDBCBank.Sessions.*;

public class SessionOptions {

	public static void startSession() {
		Driver dr = new Driver();
		Scanner sc = dr.getScanner();
		
		String answer = "";
		while(!answer.equals("register") && !answer.equals("login")) {
		System.out.println("Register or Login?");
		answer = sc.nextLine().toLowerCase();
		
		if(answer.equals("register")) {
			System.out.println("Choose your username:");
			String username = sc.nextLine().toUpperCase();
			
			System.out.println("Choose your password:");
			String password = sc.nextLine().toUpperCase();
			
			UsersDao ud = new UserDaoImpl();
			Users newUser = new Users(1, username, password);
			ud.createUser(newUser);
			
			System.out.println("You have successfully registered as a new user.\n");
			UserOptions.userSession(username, password);
			break;
		}
		else if(answer.equals("login")) {
			System.out.println("Username:");
			String username = sc.nextLine().toUpperCase();
			
			System.out.println("Password:");
			String password = sc.nextLine().toUpperCase();
			
			UsersDao ud = new UserDaoImpl();
			
			try{
				if(ud.isValidUser(username, password) == true) {
					int user_type_id = ud.getUserTypeId(username);
					if(user_type_id == 1) {
						System.out.println("You have successfully logged in as a user.\n");

						UserOptions.userSession(username, password);
					}
					else if(user_type_id == 2) {
						System.out.println("You have successfully logged in as an admin.\n");
						AdminOptions.adminSession(username, password);
					}
				}
			}catch(UserDoesNotExistException e) {
				e.printStackTrace();
			}catch(InvalidPasswordException e) {
				e.printStackTrace();
			}
			break;
		}
			System.out.println("Please enter a valid option.\n");
		}	
		
	}
	
	public static void endSession() {
		System.out.println("You have you successfully logged out.\n");
	}
}
