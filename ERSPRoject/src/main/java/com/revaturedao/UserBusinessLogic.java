package com.revaturedao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.revature.pojo.*;

public class UserBusinessLogic {


	public static boolean validateUser(String username, String inputPass) throws SQLException, ClassNotFoundException {
		User user = new User();
		UserDao userDao = new UserDao();
		user.setUserName(username);

		while (userDao.getUserbyUsername(username) == true && inputPass != null) {
			System.out.println("User exists");
			String password = userDao.getUserPassword(username);
			if (inputPass.equals(password)) {
				System.out.println("validation was successfull");
				user = userDao.getUserByUserNamePassword(username, inputPass);
				return true;
			} else {
				System.out.println("Invalid password");
				return false;
			}

		}
		return false;
	}

	public ArrayList<User> getUserDetails(String username, String password)
			throws ClassNotFoundException, SQLException {
		UserDao userDao = new UserDao();
		ArrayList<User> userArrayList = new ArrayList<User>();
		User user = null;

		if (validateUser(username, password) == true) {
			user = userDao.getUserByUserNamePassword(username, password);
			userArrayList.add(user);

			for (int i = 0; i < userArrayList.size(); i++) {
				System.out.println(userArrayList.get(i));
			}
		}
		return userArrayList;

	}
	
	public static boolean adminUser(String username, String password) throws FileNotFoundException {
		boolean isAdmin =false;
		Properties prop = new Properties();
		try {
		prop.load(ConnectionDB.class.getResourceAsStream("/connection.properties"));			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String uname = prop.getProperty("adminUsername");
		String pass = prop.getProperty("adminPassword");
		if(username.equals(uname) && password.equals(pass)) {
			isAdmin = true;
		} else {
			isAdmin = false;
		}
		return isAdmin;

	}
	
	
}
