package com.revature.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


import com.revature.dao.LoginDaoImpl;
import com.revature.dao.UserDaoImpl;

public class User {

	private String username;
	private String password;
	private int userId;
	private int[][] accounts;
	private static Scanner scan;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.userId = 0;
		this.accounts = new int[6][6]; 
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int[][] getAccounts() {
		return accounts;
	}

	public void setAccounts(int[][] accountsArray) {
		this.accounts = accountsArray;
	}

	public void setAccount(int actNum, int bal) {
		accounts[accounts.length][0] = actNum;
		accounts[accounts.length][1] = bal;
	}

	public static String createPassword() {
		System.out.println("Please enter desired password: ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String password1 = scan.next();
		System.out.println("Please re-enter password: ");
		String password2 = scan.next();
		if (!password2.equals(password1)) {
			System.out.println("Passwords did not match.");
			return createPassword();
		}
		return password1;
	}

	public static String createUsername() {
		System.out.println("Please enter desired username: ");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String username = scan.next();
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void options(Connection con, User u) throws SQLException, IOException {
		System.out.println("Please enter the number corresponding to your request:");
		System.out.println("1 - View account balance");
		System.out.println("2 - Deposit into an account");
		System.out.println("3 - Withdraw from an account");
		System.out.println("4 - Create an additional account");
		System.out.println("5 - Log out");
		System.out.println("6 - Delete account");
		scan = new Scanner(System.in);
		switch (scan.next()) {
		case "1":
			balance(con, u);
			break;
		case "2":
			UserDaoImpl.makeDeposit(con, u);
			break;
		case "3":
			UserDaoImpl.makeWithdrawal(con, u);
			break;
		case "4":
			UserDaoImpl.createAccount(con, u);
			break;
		case "5":
			LoginDaoImpl.Logout(con);
			break;
		case "6":
			UserDaoImpl.delete(con, u);
			break;
		default:
			System.out.println("Invalid entry");
			options(con, u);
		}
	}

	public static void balance(Connection con, User u) throws SQLException, IOException {
		for(int i = 0; i<6;i++) {
			System.out.println("Balance of account #"+u.getAccounts()[i][0]+" = $"+u.getAccounts()[i][1]);		
			if (u.getAccounts()[i+1][0]==0) {
				break;
			}
		}
		User.nextTransaction(con, u);
	}

	public static void nextTransaction(Connection con, User u) throws SQLException, IOException {
		System.out.println("Would you like to return to the main menu or log out?");
		System.out.println("1 - main menu");
		System.out.println("2 - log out");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		switch (scan.next()) {
		case "1":
			options(con, u);
			break;
		case "2":
			logout();
			break;
		default:
			System.out.println("Invalid entry");
			nextTransaction(con, u);
		}

	}

	public static void logout() {
		System.out.println("Thank you for visiting the bank. Please come back soon.");
	}
	
	public static int countAccounts(User u) {
		int count = 0;
		for (int i = 0; i<6; i++ ) {
			if(u.getAccounts()[i][0] != 0) {
				count++;
			}
			else {
				break;
			}
		}
		return count;
	}

}
