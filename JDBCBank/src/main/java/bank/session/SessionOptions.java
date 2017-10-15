package bank.session;

import java.util.Scanner;

import bank.dao.UsersDao;
import bank.dao.UsersDaoImpl;
import bank.domain.Users;
import bank.exceptions.InvalidPasswordException;
import bank.exceptions.UsernameDoesNotExistException;
import bank.main.Driver;
import bank.session.*;

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
			
			UsersDao ud = new UsersDaoImpl();
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
			
			UsersDao ud = new UsersDaoImpl();
			
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
			}catch(UsernameDoesNotExistException e) {
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
