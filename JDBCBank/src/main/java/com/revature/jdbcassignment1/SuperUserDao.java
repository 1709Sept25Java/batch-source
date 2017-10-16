package com.revature.jdbcassignment1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class SuperUserDao {

	public static void superUser(String userName, String passWord, int userId, int accNumber) throws IOException {

		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		prop.load(in);
		String uname = prop.getProperty("adminUsername");
		String pass = prop.getProperty("adminPassword");

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your username");
		userName = input.nextLine();
		System.out.println("Please enter your password: ");
		passWord = input.nextLine();

		if (userName.equals(uname) && passWord.equals(pass)) {

			System.out.println("Please select an operation to perform ");
			System.out.println("1. Update account holder");
			System.out.println("2. Delete user");
			System.out.println("3. Create new user");
			int i = input.nextInt();
			Connection con = null;
			CallableStatement cs = null;
			ResultSet rs = null;

			switch (i) {

			case 1: {
				System.out.println("UserId: ");
				userId = input.nextInt();
				System.out.println("New name: ");
				String newname = input.nextLine();
				System.out.println("Address: ");
				String address = input.nextLine();
				System.out.println("City: ");
				String city = input.nextLine();
				System.out.println("State: ");
				String state = input.nextLine();
				System.out.println("Country: ");
				String country = input.nextLine();
				System.out.println("Email: ");
				String eMail = input.nextLine();
				System.out.println("Phone: ");
				String phone = input.nextLine();
				
				String update = "{CALL SUPERUSER_FUNCTION.UPDATE_ACC_HOLDER (?, ?, ?, ?, ?, ?,?, ?)}";
				try {
					
					con = JavaConnectDB.getConnectionFromFile("connection.properties");
					cs = con.prepareCall(update);
					cs.setInt(1, userId);
					cs.setString(2, newname);
					cs.setString(3, address);
					cs.setString(4, city);
					cs.setString(5, state);
					cs.setString(6, country);
					cs.setString(7, eMail);
					cs.setString(8, phone);
					cs.executeUpdate();

					rs = cs.getResultSet();

					System.out.println("Admin updated the accunt holder information for :" + cs.getString(2));
				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			}
			case 2: {
				
				System.out.println("Enter the userid that you would like to delete");
				userId = input.nextInt();
				
				String delete = "{CALL SUPERUSER_FUNCTION.DELETE_ACCOUNT_HOLDER (?)}";
				try {
					
					con = JavaConnectDB.getConnectionFromFile("connection.properties");
					cs = con.prepareCall(delete);
					cs.setInt(1, userId);
					cs.executeUpdate();

					rs = cs.getResultSet();

					System.out.println("Admin deleted the user :" + cs.getInt(1));
				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			}
			case 3:
				System.out.println("Create a new username for the user");
				userName = input.nextLine();
				
				System.out.println("Create a new password");
				passWord = input.nextLine();
				
				System.out.println("Enter new user full name");
				String name = input.nextLine();
				
				String create = "{CALL SUPERUSER_FUNCTION.ADD_ACC_HOLDER (?, ?, ?, ?, ?)}";
				try {
					
					con = JavaConnectDB.getConnectionFromFile("connection.properties");
					cs = con.prepareCall(create);
					cs.registerOutParameter(1, java.sql.Types.INTEGER);
					cs.registerOutParameter(2, java.sql.Types.INTEGER);
					cs.setString(3, userName);
					cs.setString(4, passWord);
					cs.setString(5, name);

					cs.executeUpdate();
					rs = cs.getResultSet();

					System.out.println("Admin just created a new account and the account number is "+ cs.getInt(2));
				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			}
			} else
				
				System.out.println("You do not have access to this page");
			input.close();
			}
		}
	