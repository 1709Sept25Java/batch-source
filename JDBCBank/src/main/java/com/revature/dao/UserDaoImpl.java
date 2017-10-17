package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bank.User;

public class UserDaoImpl extends User implements UserDao {

	public static Scanner scan;

	public UserDaoImpl(String username, String password) {
		super(username, password);
	}

	public static User createUser(Connection con) throws SQLException, IOException {
		// calls methods to store user input for username and password
		String user = User.createUsername();
		while (checkUser(con, user) == true) {
			System.out.println("We're sorry. A user has already registered with that account.");
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
		System.out.println("You have successfully created an account at the bank!");
		User.nextTransaction(con, created);
		return created;
	}

	public static boolean checkUser(Connection con, String usernameInput) throws SQLException {
		if (usernameInput == "register" || usernameInput == "all") {
			return false; // prevents clash with input options in future methods
		}
		CallableStatement cs = null;
		String sql = "{call CHECK_USERS(?,?)}";
		cs = con.prepareCall(sql);
		cs.setString(1, usernameInput);
		cs.registerOutParameter(2, java.sql.Types.INTEGER);
		cs.execute();
		int returnValue = cs.getInt(2);
		if (returnValue == 1) {
			return true;
		}
		return false;
	}

	public static boolean checkUserId(Connection con, int userIdInput) throws SQLException {
		CallableStatement cs = con.prepareCall("{call CHECK_USER_ID(?,?)}");
		cs.setInt(1, userIdInput);
		cs.registerOutParameter(2, java.sql.Types.INTEGER);
		cs.execute();
		int returnValue = cs.getInt(2);
		if (returnValue == 1) {
			return true;
		}
		return false;
	}

	public static boolean checkPassword(Connection con, String usernameInput, String passwordInput)
			throws SQLException {
		CallableStatement cs = null;
		String sql = "{call CHECK_PASSWORD(?,?,?)}";
		cs = con.prepareCall(sql);
		cs.setString(1, usernameInput);
		cs.setString(2, passwordInput);
		cs.registerOutParameter(3, java.sql.Types.INTEGER);
		cs.execute();
		int returnValue = cs.getInt(3);
		if (returnValue == 1) {
			return true;
		}
		return false;
	}

	public static void createAccount(Connection con, User u) throws SQLException, IOException {
		if (User.countAccounts(u) == 4) {
			System.out.println(
					"You have reached the max number of accounts you can hold at the bank. Please select another option.");
			User.options(con, u);
		}
		String sql = "{call NEW_ACCOUNT(?)}";
		CallableStatement cstmt = null;
		cstmt = con.prepareCall(sql);
		cstmt.setString(1, u.getUsername());
		cstmt.execute();
		// retrieve account number generated automatically in sql
		String sql2 = "SELECT ACCOUNT_NUMBER FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(sql2);
		pstmt.setInt(1, u.getUserId());
		ResultSet rs = pstmt.executeQuery();
		int actNum = 0;
		int index = 0;
		while (rs.next()) {
			actNum = rs.getInt("ACCOUNT_NUMBER");
			u.getAccounts()[index][0] = actNum;
			index++;
		}
		System.out.println("Thanks for opening another account with us! Your new account number is " + actNum);
		nextTransaction(con, u);
	}

	public static void makeDeposit(Connection con, User u) throws SQLException, IOException {
		scan = new Scanner(System.in);
		int accountIndex;
		if (User.countAccounts(u) > 1) {
			System.out.println("Into which account would you like to make a deposit?");
			for (int i = 0; i < User.countAccounts(u); i++) {
				System.out.println((i + 1) + " - " + u.getAccounts()[i][0]);
			}
			if (scan.hasNextInt() == false) {
				System.out.println("Invalid input");
				makeDeposit(con, u);
			}
			accountIndex = scan.nextInt() - 1;
			if ((accountIndex + 1) > User.countAccounts(u)) {
				System.out.println("Invalid input");
				makeDeposit(con, u);
			}
		} else {
			accountIndex = 0;
		}
		System.out.println("Please enter the amount you would like to deposit:");
		System.out.print("$");
		if (scan.hasNextInt()) {
			int depositValue = scan.nextInt();
			int currentBalance = u.getAccounts()[accountIndex][1];
			int newBalance = currentBalance + depositValue;
			u.getAccounts()[accountIndex][1] = newBalance;
			System.out.println("You have deposited: $" + depositValue);
			System.out.println("Your account balance is now: $" + newBalance);
			// change balance associated with account in database
			String sql = "{call DEPOSIT(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, depositValue);
			cs.setInt(2, u.getAccounts()[accountIndex][0]);
			cs.execute();
			nextTransaction(con, u);
		} else {
			System.out.println("Invalid input");
			makeDeposit(con, u);
		}
	}

	public static void makeWithdrawal(Connection con, User u) throws SQLException, IOException {
		// print all account numbers for user to select
		scan = new Scanner(System.in);
		int accountIndex;
		if (User.countAccounts(u) > 1) {
			System.out.println("From which account would you like to withdraw?");
			for (int i = 0; i < User.countAccounts(u); i++) {
				System.out.println((i + 1) + " - " + u.getAccounts()[i][0]);
			}
			if (scan.hasNextInt() == false) {
				System.out.println("Invalid input");
				makeWithdrawal(con, u);
				return;
			}
			accountIndex = scan.nextInt() - 1;
			if ((accountIndex + 1) > User.countAccounts(u)) {
				System.out.println("Invalid input");
				makeWithdrawal(con, u);
				return;
			}
		} else {
			accountIndex = 0;
		}
		if (u.getAccounts()[accountIndex][1] == 0) {
			System.out.println("Account is empty.");
			System.out.println("1 - Make a withdrawal from another");
			System.out.println("2 - Return to main menu");
			switch (scan.next()) {
			case "1":
				makeWithdrawal(con, u);
			case "2":
				User.options(con, u);
			default:
				System.out.println("Invalid entry. You have been directed back to the main menu.");
				User.options(con, u);
			}
		}
		withdrawLoop(con, u, accountIndex);
		nextTransaction(con, u);
	}

	public static void withdrawLoop(Connection con, User u, int index) throws SQLException {
		scan = new Scanner(System.in);
		System.out.println("Please enter the amount you would like to withdraw:");
		System.out.print("$");
		if (scan.hasNextInt() == false) {
			System.out.println("Invalid input");
			withdrawLoop(con, u, index);
		}
		int withdrawValue = scan.nextInt();
		int currentBalance = u.getAccounts()[index][1];
		if (withdrawValue > currentBalance) {
			System.out.println("Insufficient funds. Please enter a withdrawal amount less than the balance ($"
					+ currentBalance + ")");
			withdrawLoop(con, u, index);
			return;
		}
		int newBalance = currentBalance - withdrawValue;
		u.getAccounts()[index][1] = newBalance;
		System.out.println("You have withdrawn: $" + withdrawValue);
		System.out.println("Your account balance is now: $" + newBalance);
		// change balance associated with account in database
		String sql = "{call WITHDRAW(?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, withdrawValue);
		cs.setInt(2, u.getAccounts()[index][0]);
		cs.execute();
	}

	public static void mapUser(Connection con, User u) throws SQLException {
		// retrieve id number
		String sql1 = "SELECT USER_ID FROM USERS WHERE USER_NAME = ?";
		PreparedStatement pstmt1 = con.prepareStatement(sql1);
		pstmt1.setString(1, u.getUsername());
		ResultSet rs1 = pstmt1.executeQuery();
		rs1.next();
		int user_id = rs1.getInt("USER_ID");
		u.setUserId(user_id);
		// retrieve account numbers and balances associated with id number
		String sql2 = "SELECT ACCOUNT_NUMBER, ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setInt(1, user_id);
		ResultSet rs2 = pstmt2.executeQuery();
		int i = 0;
		while (rs2.next()) {
			int act_num = rs2.getInt("ACCOUNT_NUMBER");
			int act_bal = rs2.getInt("ACCOUNT_BALANCE");
			u.getAccounts()[i][0] = act_num;
			u.getAccounts()[i][1] = act_bal;
			i++;
		}
	}

	public static void delete(Connection con, User u) throws SQLException, IOException {
		scan = new Scanner(System.in);
		int accountIndex;
		if (User.countAccounts(u) > 1) {
			System.out.println("Please enter the number corresponding to the account "
					+ "you would like to delete? If you would like to delete all of "
					+ "your accounts, enter \"all\".");
			// prints out accounts
			for (int i = 0; i < 6; i++) {
				System.out.println((i + 1) + " - " + u.getAccounts()[i][0]);
				if (u.getAccounts()[i + 1][0] == 0) {
					break;
				}
			}
			// checks if input is an number, deletes accountIndex accordingly if it is
			// if input is "all" deletes all accounts, otherwise given an error
			int numOfUserAccounts = User.countAccounts(u);
			if (scan.hasNextInt()) {
				accountIndex = scan.nextInt() - 1;
				if (accountIndex > numOfUserAccounts) {
					System.out.println("Invalid input.");
					delete(con, u);
				} else {
					deleteAccount(con, u, accountIndex);
					System.out.println("Your account has been successfully deleted");
					System.out.println("1 - Return to main menu");
					System.out.println("2 - Log out");
					switch (scan.next()) {
					case "1":
						User.options(con, u);
					case "2":
						LoginDaoImpl.Logout(con);
					default:
						System.out.println("Invalid entry. You've been redirected to the main menu");
						LoginDaoImpl.Logout(con);
					}
				}
			} else {
				String input = scan.next();
				if (input.equals("all")) {
					for (int i = 0; i < numOfUserAccounts; i++) {
						if (accountEmpty(u, i) == false) {
							System.out.println(
									"You have an outstanding balance in on or more of your accounts. Accounts must be empty to be deleted");
							System.out.println("1 - Withdraw outstanding balance(s) and delete");
							System.out.println("2 - Return to the main menu");
							switch (scan.next()) {
							case "1":
								for (int j = 0; j < numOfUserAccounts; j++) {
									if (accountEmpty(u, j) == false) {
										withdrawAll(con, u, j);
									}
								}
								break;
							case "2":
								User.options(con, u);
								break;
							default:
								System.out.println("Invalid request. You have been returned to the main method.");
								User.options(con, u);
							}
						}
					}
					Scanner scan1 = new Scanner(System.in);
					System.out.println("Please verify password to delete account");
					String pass = scan1.next();
					while (UserDaoImpl.checkPassword(con, u.getUsername(), pass) == false) {
						System.out.println("Password incorrect. Please try again.");
						pass = scan.next();
					}
					deleteAll(con, u);
				} else {
					System.out.println("Invalid input");
					delete(con, u);
					return;
				}

			}
		}

		// if user only has one account
		else {
			scan = new Scanner(System.in);
			System.out.println("Please verify password to delete account");
			String pass = scan.next();
			while (UserDaoImpl.checkPassword(con, u.getUsername(), pass) == false) {
				System.out.println("Password incorrect. Please try again.");
				pass = scan.next();
			}
			deleteAll(con, u);
		}
	}

	public static boolean accountEmpty(User u, int index) {
		if (u.getAccounts()[index][1] == 0) {
			return true;
		}
		return false;
	}

	public static void withdrawAll(Connection con, User u, int index) throws SQLException {
		int withdrawValue = u.getAccounts()[index][1];
		u.getAccounts()[index][1] = 0;
		System.out.println("You have withdrawn: $" + withdrawValue + " from Account #" + u.getAccounts()[index][0]);
		// change balance associated with account in database
		String sql = "{call WITHDRAW(?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, withdrawValue);
		cs.setInt(2, u.getAccounts()[index][0]);
		cs.execute();

	}

	public static void deleteAll(Connection con, User u) throws SQLException {
		String sql1 = "DELETE FROM ACCOUNTS WHERE ACCOUNTHOLDER_ID = ?";
		PreparedStatement pstmt1 = con.prepareStatement(sql1);
		pstmt1.setInt(1, u.getUserId());
		pstmt1.execute();
		String sql2 = "DELETE FROM USERS WHERE USER_ID = ?";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setInt(1, u.getUserId());
		pstmt2.execute();
		u = null;
		System.out.println("Your account(s) have been deleted. We're sorry to see you go!");
		con.close();
		System.exit(0);
	}

	public static void deleteAccount(Connection con, User u, int index) throws SQLException, IOException {
		scan = new Scanner(System.in);
		int numOfUserAccounts = User.countAccounts(u);
		if (accountEmpty(u, index)) {
			System.out.println("Please verify password to delete account");
			String pass = scan.next();
			while (UserDaoImpl.checkPassword(con, u.getUsername(), pass) == false) {
				System.out.println("Password incorrect. Please try again.");
				pass = scan.next();
			}
			// delete account from DB
			String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNT_NUMBER = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, u.getAccounts()[index][0]);
			pstmt.execute();
			// delete account from Java object
			u.getAccounts()[index][0] = 0;
			u.getAccounts()[index][1] = 0;
			// if account deleted wasn't the last account,
			// accounts are moved up in the index to fill the deleted account's spot
			if (index != (numOfUserAccounts - 1)) {
				for (int i = index; i < numOfUserAccounts; i++) {
					if (i == 6) { // prevent index out of bounds if 1 of 6 accounts is deleted
						u.getAccounts()[i][0] = 0;
						u.getAccounts()[i][1] = 0;
						break;
					}
					u.getAccounts()[i][0] = u.getAccounts()[i + 1][0];
					u.getAccounts()[i][1] = u.getAccounts()[i + 1][1];
				}
			}
		} else {
			System.out.println("Accounts with a nonzero balance cannot be deleted.");
			System.out.println("1 - Withdraw balance and delete account");
			System.out.println("2 - Main menu");
			String scanString = scan.next();
			switch (scanString) {
			case "1":
				withdrawAll(con, u, index);
				deleteAccount(con, u, index);
				break;
			case "2":
				User.options(con, u);
				break;
			case "3":
				System.out.println("Invalid request.");
				deleteAccount(con, u, index);
			}
		}
	}
}

// --- come back to make non integer deposits ---
// double depositValue = scan.nextInt();
// double currentBalance = 0;
// double depositValue = 1;
// if ((depositValue - Math.floor(depositValue * 100)) != 0) {
// System.out.println("Invalid entry");
// makeDeposit(con, u);
// }
// double newBalance = currentBalance - depositValue;
