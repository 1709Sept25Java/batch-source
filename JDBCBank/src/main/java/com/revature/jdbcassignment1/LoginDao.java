package com.revature.jdbcassignment1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDao {

	static Scanner input = new Scanner(System.in);

	public static boolean validate(String userName, String userPass) throws SQLException {

		System.out.println("Enter your username ");
		userName = input.nextLine();
		System.out.println("Enter your password ");
		userPass = input.nextLine();

		boolean status = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			con = JavaConnectDB.getConnectionFromFile("connection.properties");
			ps = con.prepareStatement("SELECT * FROM USER_TABLE WHERE USERNAME=? AND UPASSWORD=?");
			ps.setString(1, userName);
			ps.setString(2, userPass);
			rs = ps.executeQuery();
			while (status = rs.next()) {
				System.out.println("You are logged in as " + userName);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;

	}

	public static boolean invalidate() {

		System.out.println("Do you want to: ");
		System.out.println("1. LogOut");
		System.out.println("2. Keep me logged in");
		int i = input.nextInt();
		switch (i) {
		case 1: {
			System.out.println("You have been logged out");

			break;
		}
		case 2: {
			System.out.println("Enjoy your session");
			break;
		}

		}
		return true;
	}

}
