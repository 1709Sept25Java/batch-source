package com.revature.domain;

public class Employee {

	public Employee(String fName, String lName, Department dep, int salary, String email) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.dep = dep;
		this.salary = salary;
		this.email = email;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	
	private String fName;
	
	private String lName;
	
	private Department dep;
	
	private int salary;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", dep=" + dep + ", salary=" + salary
				+ ", email=" + email + "]";
	}
	
}
