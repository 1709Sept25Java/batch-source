package com.revature.jdbcassignment1;

import java.sql.SQLException;

public class UserOperation {

	private Integer userId;
	private Integer accNumber;
	private float balance, amount;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public UserOperation() {
		super();

	}

	public static void perform() {
		int accNumber = 0, userId = 0;
		float amount = 0;
		try {
			UserOperationDao.performOperation(accNumber, userId, amount);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void regiterNewUser() throws SQLException {
		String name = "";
		String userName = "";
		String passWord = " ";

		RegisterDao.unregisterredUser(name, userName, passWord);

	}

}
