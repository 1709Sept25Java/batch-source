package com.revature.jdbcassignment1;

import java.io.IOException;

public class SuperUser {

	private String userName, passWord;
	private int userId, accNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}

	public SuperUser() {
		super();
	}

	public SuperUser(String userName, String passWord, int userId, int accNumber) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.userId = userId;
		this.accNumber = accNumber;
	}

	public void superUserFunction() {
		;
		try {
			SuperUserDao.superUser(userName, passWord, userId, accNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
