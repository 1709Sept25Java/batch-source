package com.revature.sql;

public class Department {

	private Object depId;
	private String DepName;

	public Department (String depName, int depId) {
		super ();
		this.DepName = depName;
		this.depId = depId;
	}
	
	public Department(Object depId, String depName) {
		super();
		this.depId = depId;
		DepName = depName;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", DepName=" + DepName + "]";
	}
	public Department() {
		super();
		
	}
	
	public void setDepId(Object depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return DepName;
	}
	public void setDepName(String depName) {
		DepName = depName;
	}
}
