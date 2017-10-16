package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.bank.User;

public interface UserDao {

	public static void createUser(Connection con) throws SQLException, IOException {
	}

	public static boolean checkUser(Connection con, String usernameInput) throws SQLException {
		return false;
	}

	public static boolean checkPassword(Connection con, String usernameInput, String passwordInput)
			throws SQLException {
		return false;
	}

	public static void createAccount(Connection con, User u) throws SQLException, IOException {

	}

	public static void makeDeposit(Connection con, User u) throws SQLException, IOException {

	}

	public static void makeWithdrawal(Connection con, User u) throws SQLException, IOException {

	}

	public static void mapUser(Connection con, User u) throws SQLException {

	}

	public static void delete(Connection con, User u) throws SQLException, IOException {

	}

}
