package com.revature.assignment1.question07;

/*
 * Employee Class 
 * Contains:
	 * Variables: age, department & name
	 * Constructors with and without parameters
	 * Getter functions for each variable
 */
public class Employee {
	String name;
	String department;
	int age;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String toString() {
        return this.name + " " + this.department + " " + this.age;
    }

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getAge() {
		return age;
	}

}
