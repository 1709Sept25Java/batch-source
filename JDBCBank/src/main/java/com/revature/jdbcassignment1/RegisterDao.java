package com.revature.jdbcassignment1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterDao {

	public static void unregisterredUser(String name, String userName, String passWord) throws SQLException {

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your ful name: ");
		name = input.nextLine();
		System.out.println("Create a username for yourself");
		userName = input.nextLine();
		System.out.println("Now create a password: ");
		passWord = input.nextLine();

		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		String register = "{CALL UNREGISTER_USER (?, ?, ?, ?, ?)}";
		try {
			con = JavaConnectDB.getConnectionFromFile("connection.properties");
			cs = con.prepareCall(register);
			cs.setInt(1, 30);
			cs.registerOutParameter(1, java.sql.Types.INTEGER);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			cs.setString(3, userName);
			cs.setString(4, passWord);
			cs.setString(5, name);
			cs.executeUpdate();

			rs = cs.getResultSet();

			System.out.println("Your new userid and account number is :" + cs.getInt(1) + "and" + cs.getInt(2));
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (rs != null) {
				rs.close();
			}
			if (cs != null) {
				cs.close();
			}
			if (con != null) {
				con.close();
			}
		}
		input.close();

	}
}
