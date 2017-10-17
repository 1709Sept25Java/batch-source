package com.revature.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.revature.bank.SuperUser;
import com.revature.bank.User;
import com.revature.util.ConnectionUtil;

public class LoginDaoImpl implements LoginDao{
	
	private static Scanner scan;

	public static void Welcome() throws IOException, SQLException {
		Connection con = null;
		con = ConnectionUtil.getAdminConnection();
		System.out.println("Hello and welcome to the bank! Are you a returning user?");
		System.out.println("1 - Yes");
		System.out.println("2 - No");
		scan = new Scanner(System.in);
		switch (scan.next()) {
			case "1":
				Login(con);
				return;
			case "2":
				UserDaoImpl.createUser(con);
				return;
			default:
				System.out.println("Invalid input. Let's try that again.");
				Welcome();
				return;
		}
	}

	public static void Logout(Connection con) throws SQLException {
		System.out.println("Thanks for banking with us today. Please come back soon!");
		con.close();
		System.exit(0);
	}

	public static void Login(Connection con) throws SQLException, IOException {
		System.out.println("Welcome back! Please enter your username:");
		scan = new Scanner(System.in);
		String input = scan.next();
		boolean admin = checkAdmin(con, input);
		if (admin == true) {return;}

		while (UserDaoImpl.checkUser(con, input) == false){
			System.out.println("Doesn't look like that username is registered yet.");
			System.out.println("Try entering your username again - or enter \"register\" to register");
			input = scan.next();
			if (input.equals("register")) {
				UserDaoImpl.createUser(con);
				return;
			}
		}
		System.out.println("Hello, "+input+". Please enter your password:");
		String pass = scan.next();
		while( UserDaoImpl.checkPassword(con, input, pass) == false ) {
			System.out.println("Password incorrect. Please try again.");
			pass = scan.next();
		}
		User u = new User(input, pass);
		UserDaoImpl.mapUser(con, u);
		User.options(con, u);
	}
	
	public static boolean checkAdmin(Connection con, String str) throws IOException, SQLException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("adminConnection.properties");
		prop.load(in);
		if (str.equals(prop.getProperty("user")) == false) {
			return false;
		}
		scan = new Scanner(System.in);
		System.out.println("Please enter Admin password:");
			if (scan.next().equals(prop.getProperty("pass"))) {
				SuperUser.options(con);
				return true;
			}
			else{
				System.out.println("Inccorect password.");
				Login(con);
				return false;
			}
	}
	
}
