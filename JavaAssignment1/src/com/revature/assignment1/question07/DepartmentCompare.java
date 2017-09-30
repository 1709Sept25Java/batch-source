package com.revature.assignment1.question07;

import java.util.Comparator;

public class DepartmentCompare implements Comparator<Employee>{
	
	public DepartmentCompare() {
		super();
	}
	
	public int compare(Employee e1, Employee e2) {
		String d1 = e1.getDepartment();
		return d1.compareTo(e2.getDepartment());
	}
}
