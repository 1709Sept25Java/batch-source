package com.revature.staff;

import java.io.Serializable;

public abstract class Employee implements Serializable {
	
	
	private static final long serialVersionUID = -2247878539127118785L;


	public Employee() {
		super();
		
	}

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	
	}
	
	protected String name;
	
	protected String department;
	
	protected int age;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
}
