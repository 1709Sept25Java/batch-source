package com.revature.question07;

/*
 * Basic Employee class consisting of name, department, age and their 
 * getter and setter functions.
 * */
public class Employee {

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public Employee() {
		super();
	}

	private String name;
	 
	private String department;
	 
	private int age;

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
