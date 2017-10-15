package com.revature.domain;

public class Users {

	public Users(int id, String username, String fname, String lname, boolean isAdmin) {
		super();
		this.id = id;
		this.username = username;
		this.fname = fname;
		this.lname = lname;
		this.isAdmin = isAdmin;
	}
	public Users(int id, String username, String password, String fname, String lname, boolean isAdmin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.isAdmin = isAdmin;
	}
	public Users(String username, String password, String fname, String lname, boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.isAdmin = isAdmin;
	}
	public Users() {
		super();
	}
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String fname;
	
	private String lname;
	
	private boolean isAdmin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Users [id= "+id+" username=" + username + ", fname=" + fname + ", lname=" + lname
				+ ", isAdmin=" + isAdmin + "]";
	}
}
