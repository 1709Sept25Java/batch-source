package com.revature.staff;

import java.io.Serializable;

public class NewYorkStaff extends Employee implements Comparable<NewYorkStaff>,Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NewYorkStaff() {
		super();
	
	}

	public NewYorkStaff(String name, String department, int age) {
		super(name, department, age);
		
	} 


	@Override
	public String toString() {
		return "NewYorkStaff [name=" + name + ", department=" + department + ", age=" + age + "]";
}

	@Override
	public int compareTo(NewYorkStaff m) {
		return this.department.compareTo(m.department);
	}
	

}