package com.revature.domain;

public class UserRoles {
	int urrid;
	String urrole;
	public int getUrid() {
		return urrid;
	}
	public void setUrid(int urid) {
		this.urrid = urid;
	}
	public String getUrrole() {
		return urrole;
	}
	public void setUrrole(String urrole) {
		this.urrole = urrole;
	}
	@Override
	public String toString() {
		return "UserRoles [urid=" + urrid + ", urrole=" + urrole + "]";
	}
	public UserRoles(int urid, String urrole) {
		super();
		this.urrid = urid;
		this.urrole = urrole;
	}
	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
