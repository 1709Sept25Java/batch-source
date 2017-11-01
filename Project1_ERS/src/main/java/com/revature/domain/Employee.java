package com.revature.domain;

public class Employee {

	public Employee() {
		super();
	}
	
	private int emplid;
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee(int emplid,String firstName,String lastName,String email) {
		this.emplid = emplid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public int getEmplid() {
		return emplid;
	}
	
	public void setEmplid(int emplid) {
		this.emplid = emplid;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Employee [emplid=" + emplid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
}
