package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bank.SuperUser;
import com.revature.bank.User;

public class SuperUserDaoImpl implements SuperUserDao {

	private static Scanner scan;

	public static void viewUser(Connection con) throws SQLException, IOException {
		System.out.println(
				"Enter the username or user ID for the user you'd like to view -- or enter \"all\" to view all users.");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		if (scan.hasNextInt()) {
			int userId = scan.nextInt();
			String sql1 = "SELECT USER_NAME, USER_PASS FROM USERS WHERE USER_ID = ?";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, userId);
			ResultSet rs1 = pstmt1.executeQuery();
			String username = "unavailable";
			String password = "unavailable";
			while (rs1.next()) {
				username = rs1.getString("USER_NAME");
				password = rs1.getString("USER_PASS");
			}
			User u = new User(username, password);
			u.setUserId(userId);
			// find by user id
			String sql2 = "SELECT ACCOUNT_NUMBER, ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, userId);
			ResultSet rs2 = pstmt2.executeQuery();
			int count = 0;
			while (rs2.next()) {
				int actNum = rs2.getInt("ACCOUNT_NUMBER");
				int actBal = rs2.getInt("ACCOUNT_BALANCE");

				u.getAccounts()[count][0] = actNum;
				u.getAccounts()[count][1] = actBal;
				count++;
			}
			printUser(u);
			if (count == 0) {
				System.out.println("");
				System.out.println("No current users.");
				System.out.println("");
			}
		} else {
			String input = scan.next();
			if (input.equals("all")) {
				String sql1 = "SELECT USER_NAME, USER_PASS, USER_ID FROM USERS";
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				ResultSet rs1 = pstmt1.executeQuery();
				String username = "unavailable";
				String password = "unavailable";
				int userId = 0;
				while (rs1.next()) {
					username = rs1.getString("USER_NAME");
					password = rs1.getString("USER_PASS");
					userId = rs1.getInt("USER_ID");
					User u = new User(username, password);
					u.setUserId(userId);
					// find by user id
					String sql2 = "SELECT ACCOUNT_NUMBER, ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
					pstmt2.setInt(1, userId);
					ResultSet rs2 = pstmt2.executeQuery();
					int count = 0;
					while (rs2.next()) {
						int actNum = rs2.getInt("ACCOUNT_NUMBER");
						int actBal = rs2.getInt("ACCOUNT_BALANCE");
						u.getAccounts()[count][0] = actNum;
						u.getAccounts()[count][1] = actBal;
						count++;
					}
					printUser(u);
					System.out.println();
				}
			} else {
				String username = input;
				if (UserDaoImpl.checkUser(con, username) == false) {
					System.out.println("User not found");
					viewUser(con);
				}
				String sql1 = "SELECT USER_ID, USER_PASS FROM USERS WHERE USER_NAME = ?";
				PreparedStatement pstmt1 = con.prepareStatement(sql1);
				pstmt1.setString(1, username);
				ResultSet rs1 = pstmt1.executeQuery();
				int userId = 0;
				String password = "password unavailable";
				while (rs1.next()) {
					userId = rs1.getInt("USER_ID");
					password = rs1.getString("USER_PASS");
				}
				User u = new User(username, password);
				u.setUserId(userId);
				// find by user id
				String sql2 = "SELECT ACCOUNT_NUMBER, ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt2.setInt(1, userId);
				ResultSet rs2 = pstmt2.executeQuery();
				int count = 0;
				while (rs2.next()) {
					int actNum = rs2.getInt("ACCOUNT_NUMBER");
					int actBal = rs2.getInt("ACCOUNT_BALANCE");

					u.getAccounts()[count][0] = actNum;
					u.getAccounts()[count][1] = actBal;
					count++;
				}
				printUser(u);
			}
		}
		SuperUserDaoImpl.nextTransaction(con);
		return;// return to main or log out?
	}

	public static void printUser(User u) {
		System.out.println("User ID: " + u.getUserId() + ",    Username: " + u.getUsername() + ",    Password: "
				+ u.getPassword());
		int numAccounts = User.countAccounts(u);
		for (int i = 0; i < numAccounts; i++) {
			System.out.println("[ Account #" + u.getAccounts()[i][0] + " : $" + u.getAccounts()[i][1] + " ]  ");
		}
	}

	public static void createNewUser(Connection con) throws SQLException, IOException {
		// calls methods to store user input for username and password
		String user = User.createUsername();
		while (UserDaoImpl.checkUser(con, user) == true) {
			System.out.println("A user has already registered with that account.");
			user = User.createUsername();
		}
		String pass = User.createPassword();
		// executes a stored method creating a new user with these credentials
		String sql1 = "{call NEW_USER(?,?)}";
		CallableStatement cs = null;
		cs = con.prepareCall(sql1);
		cs.setString(1, user);
		cs.setString(2, pass);
		cs.execute();
		User created = new User(user, pass);
		// retrieve user id number generated automatically in sql
		String sql2 = "SELECT USER_ID FROM USERS WHERE USER_NAME = ?";
		PreparedStatement pstmt1 = null;
		pstmt1 = con.prepareStatement(sql2);
		pstmt1.setString(1, user);
		ResultSet rs1 = pstmt1.executeQuery();
		int id = 0;
		while (rs1.next()) {
			id = rs1.getInt("USER_ID");
			created.setUserId(id);
		}
		// retrieve account number generated automatically in sql
		String sql3 = "SELECT ACCOUNT_NUMBER FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
		PreparedStatement pstmt2 = null;
		pstmt2 = con.prepareStatement(sql3);
		pstmt2.setInt(1, id);
		ResultSet rs2 = pstmt2.executeQuery();
		int actNum = 0;
		while (rs2.next()) {
			actNum = rs2.getInt("ACCOUNT_NUMBER");
			created.getAccounts()[0][0] = actNum;
		}
		System.out.println("User has been created.");
		SuperUserDaoImpl.nextTransaction(con);
	}

	public static void updateUser(Connection con) throws SQLException, IOException {
		System.out.println("Enter the username or user ID for the user you'd like to update:");
		User u = new User("", "");
		String username;
		String password;
		scan = new Scanner(System.in);
		if (scan.hasNextInt()) {
			int userId = scan.nextInt();
			if (UserDaoImpl.checkUserId(con, userId) == false) {
				System.out.println("User not found");
				updateUser(con);
			}
			String sql1 = "SELECT USER_NAME, USER_PASS FROM USERS WHERE USER_ID = ?";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, userId);
			ResultSet rs1 = pstmt1.executeQuery();
			username = "unavailable";
			password = "unavailable";
			while (rs1.next()) {
				username = rs1.getString("USER_NAME");
				password = rs1.getString("USER_PASS");
			}
			pstmt1.close();
			u.setUserId(userId);
			u.setPassword(password);
			u.setUsername(username);
			// find by user id
			String sql2 = "SELECT ACCOUNT_NUMBER, ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, userId);
			ResultSet rs2 = pstmt2.executeQuery();
			int count = 0;
			while (rs2.next()) {
				int actNum = rs2.getInt("ACCOUNT_NUMBER");
				int actBal = rs2.getInt("ACCOUNT_BALANCE");

				u.getAccounts()[count][0] = actNum;
				u.getAccounts()[count][1] = actBal;
				count++;
			}

		} else {
			username = scan.next();
			if (UserDaoImpl.checkUser(con, username) == false) {
				System.out.println("User not found");
				updateUser(con);
			}
			String sql1 = "SELECT USER_ID, USER_PASS FROM USERS WHERE USER_NAME = ?";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setString(1, username);
			ResultSet rs1 = pstmt1.executeQuery();
			int userId = 0;
			password = "password unavailable";
			while (rs1.next()) {
				userId = rs1.getInt("USER_ID");
				password = rs1.getString("USER_PASS");
			}
			pstmt1.close();
			u.setUsername(username);
			u.setPassword(password);
			u.setUserId(userId);
			// find by user id
			String sql2 = "SELECT ACCOUNT_NUMBER, ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, userId);
			ResultSet rs2 = pstmt2.executeQuery();
			int count = 0;
			while (rs2.next()) {
				int actNum = rs2.getInt("ACCOUNT_NUMBER");
				int actBal = rs2.getInt("ACCOUNT_BALANCE");

				u.getAccounts()[count][0] = actNum;
				u.getAccounts()[count][1] = actBal;
				count++;
			}
			pstmt2.close();
		}
		System.out.println("Which field would you like to update?");
		System.out.println("1 - username");
		System.out.println("2 - password");
		System.out.println("3 - account balance");
		if (!scan.hasNextInt()) {
			System.out.println("Invalid entry.");
			updateUser(con);
			return;
		}
		String selection = scan.next();
		switch (selection) {
		case "1":
			System.out.println("Current username is " + u.getUsername() + ".");
			System.out.println("Enter new username:");
			String newUser = scan.next();
			UserDaoImpl.checkUser(con, newUser);
			while (UserDaoImpl.checkUser(con, newUser) == true) {
				System.out.println("We're sorry. A user has already registered with that account.");
				newUser = User.createUsername();
			}
			System.out.println("Username has been changed from " + u.getUsername() + " to " + newUser);
			u.setUsername(newUser);
			String sql3 = "UPDATE USERS SET USER_NAME = ? WHERE USER_ID = ?";
			PreparedStatement pstmt3 = con.prepareStatement(sql3);
			pstmt3.setString(1, u.getUsername());
			pstmt3.setInt(2, u.getUserId());
			pstmt3.execute();
			pstmt3.close();
			nextTransaction(con);
			return;
		case "2":
			System.out.println("Current pasword is " + u.getPassword() + ".");
			password = User.createPassword();
			System.out.println("Password has been changed from to " + u.getPassword() + " to " + password);
			u.setPassword(password);
			String sql4 = "UPDATE USERS SET USER_PASS = ? WHERE USER_ID = ?";
			PreparedStatement pstmt4 = con.prepareStatement(sql4);
			pstmt4.setString(1, u.getPassword());
			pstmt4.setInt(2, u.getUserId());
			pstmt4.execute();
			pstmt4.close();
			nextTransaction(con);
			return;
		case "3":
			int accountIndex = getAccountIndex(con , u);
			int accountNum = u.getAccounts()[accountIndex-1][0];
			System.out.println("What would you like to change the account balance to?");
			int balance = scan.nextInt();
			String sql5 = "UPDATE ACCOUNTS SET ACCOUNT_BALANCE = ? WHERE ACCOUNT_NUMBER = ?";
			PreparedStatement pstmt5 = con.prepareStatement(sql5);
			pstmt5.setInt(1, balance);
			pstmt5.setInt(2, accountNum);
			pstmt5.execute();
			pstmt5.close();
			System.out.println("Account has been updated.");
			nextTransaction(con);
			return;
		default:
			System.out.println("Invalid entry.");
			updateUser(con);
		}

	}
	
	public static int getAccountIndex(Connection con, User u) {
		int numAccounts = User.countAccounts(u);
		for (int i = 0; i < numAccounts; i++) {
			System.out.println("");
			System.out.println(
					(i + 1) + " - [ Account #" + u.getAccounts()[i][0] + " : $" + u.getAccounts()[i][1] + " ]");
			System.out.println("");
		}
		System.out.println("Which account balance would you like to update?");
		int accountIndex = 0;
		if (scan.hasNextInt() == false) {
			scan.next();
			System.out.println("Invalid entry");
			accountIndex = getAccountIndex(con, u);
		} else {
			accountIndex = scan.nextInt();
			if(numAccounts<accountIndex | accountIndex<=0) {
				System.out.println("Invalid entry");
				accountIndex = getAccountIndex(con, u);
			} 
		}
		return accountIndex;
	}

	public static void deleteUser(Connection con) throws SQLException, IOException {
		System.out.println(
				"Enter the username or user ID for the user you'd like to delete -- or enter \"all\" to delete all users.");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		if (scan.hasNextInt()) {
			int userId = scan.nextInt();
			String sql1 = "DELETE FROM USERS WHERE USER_ID = ?";
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			pstmt1.setInt(1, userId);
			pstmt1.execute();
		} else {
			String input = scan.next();
			if (input.equals("all")) {
				String sql2 = "DELETE FROM ACCOUNTS";
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				pstmt2.executeUpdate();
				String sql3 = "ALTER TABLE ACCOUNTS DROP CONSTRAINT FK_USER_ID";
				PreparedStatement pstmt3 = con.prepareStatement(sql3);
				pstmt3.executeUpdate();
				String sql4 = "DELETE FROM USERS";
				PreparedStatement pstmt4 = con.prepareStatement(sql4);
				pstmt4.executeUpdate();
				String sql5 = "ALTER TABLE ACCOUNTS ADD CONSTRAINT FK_USER_ID FOREIGN KEY (ACCOUNTHOLDER_ID) REFERENCES USERS (USER_ID) ON DELETE SET NULL";
				PreparedStatement pstmt5 = con.prepareStatement(sql5);
				pstmt5.executeUpdate();
			} else {
				String username = input;
				String sql4 = "DELETE FROM USERS WHERE USER_NAME = ?";
				PreparedStatement pstmt4 = con.prepareStatement(sql4);
				pstmt4.setString(1, username);
				pstmt4.execute();
			}
		}
		System.out.println("Account(s) have been deleted.");
		SuperUserDaoImpl.nextTransaction(con); // return to main or log out?
	}

	public static void nextTransaction(Connection con) throws SQLException, IOException {
		System.out.println("Would you like to return to the main menu or log out?");
		System.out.println("1 - main menu");
		System.out.println("2 - log out");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		switch (scan.next()) {
		case "1":
			SuperUser.options(con);
			break;
		case "2":
			LoginDaoImpl.Logout(con);
			break;
		default:
			System.out.println("Invalid entry");
			nextTransaction(con);
		}

	}

}
