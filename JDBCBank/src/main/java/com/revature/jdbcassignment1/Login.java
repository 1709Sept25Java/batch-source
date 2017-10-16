package com.revature.jdbcassignment1;

import java.sql.SQLException;

public class Login {

	private String userName, userPass;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public Login() {
		super();
	}

	public Login(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}

	public void execute() {
		try {
			if (LoginDao.validate(userName, userPass)) {
				System.out.println("  Welcome!");
				if (LoginDao.invalidate()) {
					System.out.println(" ");
				} else {
					System.out.println(" Have fun!");
				}
			} else {
				System.out.println("Invalid Username or password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
