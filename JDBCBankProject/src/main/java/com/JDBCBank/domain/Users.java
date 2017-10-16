package com.JDBCBank.domain;

public class Users {
	private int userId;
	private int userTypeId; 
	private String username; 
	private String password; 
	
	public Users() {
		super();
	}
	public Users(int UserTypeId, String username, String password) {
		super();
		this.userTypeId = userTypeId;
		this.username = username; 
		this.password = password;
	}
	public Users (String username, String password) {
		super();
		this.username = username; 
		this.password = password;
	}

	public Users(int userId, int useTypeId, String username, String password) {
		super();
		this.userId = userId; 
		this.userTypeId = userTypeId;
		this.username = username; 
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userTypeId=" + userTypeId + ", username=" + username + ", password="
				+ password + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
