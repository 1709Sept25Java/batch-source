package com.revature.domain;



public class Users {
	private int userid, urid;
	private String username, password, firstname, lastname, email;
	
	


	public int getuserid() {
		return userid;
	}
	public void setuserid(int userid) {
		this.userid = userid;
	}
	public int geturid() {
		return urid;
	}
	public void seturid(int urid) {
		this.urid = urid;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Users() {
		super();

	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", urid=" + urid + ", username=" + username + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}
	public void setValid(boolean b) {
		// TODO Auto-generated method stub

	}
	public boolean isValid(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Users(int userid, int urid, String username, String password, String firstname, String lastname,
			String email) {
		super();
		this.userid = userid;
		this.urid = urid;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public Users(int userid2, String urid2, String username2, String password2, String firstname2, String lastname2,
			String email2) {
	}




}
