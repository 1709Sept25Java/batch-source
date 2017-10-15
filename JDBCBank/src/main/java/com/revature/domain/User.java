package com.revature.domain;

public class User {
	
	//Different constructors for different cases | ex: we don't always want a user's password
	public User(int userID, String userName, String userPassword, String userType) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userType = userType;
	}
	
	public User(int userID, String userType) {
		super();
		this.userID = userID;
		this.userType = userType;
	}
	
	public User(int userID, String username, String userType) {
		super();
		this.userID = userID;
		this.userName = username;
		this.userType = userType;
	}
	
	public User() {
		super();
	}
	private int userID;
	private String userName;
	private String userPassword;
	private String userType;
	
	//Get & Set functions
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	//Printing in a column-sort of way
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s", userID, userName, userType); 
	}
}
