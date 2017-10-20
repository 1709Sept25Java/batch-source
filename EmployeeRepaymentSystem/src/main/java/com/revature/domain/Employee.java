package com.revature.domain;

public class Employee {

	public Employee(int id, String username, String password, String fName, String lName, String email, boolean isMgr) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.isMgr = isMgr;
	}

	public Employee() {
		super();
	}

	private int id;
	
	private String username;
	
	private String password;
	
	private String fName;
	
	private String lName;
	
	private String email;
	
	private boolean isMgr;

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

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMgr() {
		return isMgr;
	}

	public void setMgr(boolean isMgr) {
		this.isMgr = isMgr;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + ", email=" + email + ", isMgr=" + isMgr + "]";
	}
	
}
