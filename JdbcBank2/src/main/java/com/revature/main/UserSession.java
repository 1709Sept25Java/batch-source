package com.revature.main;

import com.revature.domain.Users;

public class UserSession {
	
	public static void userSession(Users user) {
		
		//Call to show user accounts!!!
		
		System.out.println("Please select an item from the list below:");
		System.out.println("\t 1) Create new account");
		System.out.println("\t 2) Delete account");
		System.out.println("\t 3) Withdraw from an account");
		System.out.println("\t 4) Deposit into an account");
	}
	
	public static void adminSession(Users user) {
		
		//Call to show all use accounts
		
		System.out.println("Please select an item from the list below:");
		System.out.println("\t 1) Create new user");
		System.out.println("\t 2) Delete a user");
		System.out.println("\t 3) Alter user rights");
	}

}
