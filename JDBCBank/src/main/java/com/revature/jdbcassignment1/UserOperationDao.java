package com.revature.jdbcassignment1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserOperationDao {

	public static void performOperation(int accNumber, int userId, float amount) throws SQLException {

		Scanner input = new Scanner(System.in);
		System.out.println("Please select an operation to perform ");
		System.out.println("1. Check my balance");
		System.out.println("2. Make a deposit");
		System.out.println("3. Make a withdraw");
		System.out.println("4. Open a new account");
		System.out.println("5. Delete my account");
		int i = input.nextInt();

		switch (i) {
		case 1: {
			Connection con = null;
			CallableStatement cs = null;
			ResultSet rs = null;
			String balanceInquiry = "{CALL BALANCE_INQUIRY (?,?)}";
			try {
				System.out.println("Enter your account number");
				accNumber = input.nextInt();

				con = JavaConnectDB.getConnectionFromFile("connection.properties");
				cs = con.prepareCall(balanceInquiry);
				cs.setInt(1, 10);
				cs.setInt(1, accNumber);
				cs.registerOutParameter(2, java.sql.Types.NUMERIC);
				cs.executeUpdate();

				rs = cs.getResultSet();

				System.out.println("Your current balance is:" + cs.getInt(2));

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
			break;
		}
		case 2: {

			System.out.println("How much would you like to deposit?");
			amount = input.nextFloat();
			System.out.println("Please enter your account number");
			accNumber = input.nextInt();

			Connection con = null;
			CallableStatement cs = null;
			ResultSet rs = null;
			String deposit = "{CALL DEPOSIT_PROCEDURE (?, ?, ?)}";
			try {

				con = JavaConnectDB.getConnectionFromFile("connection.properties");
				cs = con.prepareCall(deposit);
				cs.setInt(1, 10);
				cs.setFloat(1, amount);
				cs.setInt(2, accNumber);
				cs.registerOutParameter(3, java.sql.Types.NUMERIC);
				cs.executeUpdate();

				rs = cs.getResultSet();
				System.out.println("Your new balance is" + cs.getInt(3));

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
			break;
		}
		case 3: {

			System.out.println("Please enter your account number");
			accNumber = input.nextInt();
			System.out.println("Please enter the amount you would like to withdraw");
			amount = input.nextFloat();

			Connection con = null;
			CallableStatement cs = null;
			ResultSet rs = null;
			String withdraw = "{CALL withdrawal_procedure (?, ?, ?)}";
			try {

				con = JavaConnectDB.getConnectionFromFile("connection.properties");
				cs = con.prepareCall(withdraw);
				cs.setInt(1, 20);
				cs.setInt(1, accNumber);
				cs.setFloat(2, amount);
				cs.registerOutParameter(3, java.sql.Types.NUMERIC);
				cs.executeUpdate();

				rs = cs.getResultSet();
				System.out.println("Your updated balance is " + cs.getInt(3));
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
			break;
		}
		case 4: {

			System.out.println("Please enter your userid");
			userId = input.nextInt();

			Connection con = null;
			CallableStatement cs = null;
			ResultSet rs = null;
			String newAccount = "{CALL CREATE_NEW_ACCOUNT (?,?)}";
			try {

				con = JavaConnectDB.getConnectionFromFile("connection.properties");
				cs = con.prepareCall(newAccount);
				cs.setInt(1, 20);
				cs.setInt(1, userId);
				cs.registerOutParameter(2, java.sql.Types.INTEGER);
				cs.executeUpdate();
				rs = cs.getResultSet();

				System.out.println("Your new account number is" + cs.getInt(2));

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
			break;
		}
		case 5: {
			Connection con = null;
			CallableStatement cs = null;
			ResultSet rs = null;
			String delete = "{CALL DELETE_ACCOUNT (?)}";
			try {

				System.out.println("Please enter your account number");
				accNumber = input.nextInt();

				con = JavaConnectDB.getConnectionFromFile("connection.properties");
				cs = con.prepareCall(delete);
				cs.setInt(1, accNumber);

				cs.executeUpdate();
				rs = cs.getResultSet();
				System.out.println("The account " + accNumber + "was deleted");
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
			break;
		}

		}
		input.close();

	}
}
