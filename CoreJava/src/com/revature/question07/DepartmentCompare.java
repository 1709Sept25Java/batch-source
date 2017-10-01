package com.revature.question07;

import java.util.Comparator;

/*
 * Implements the Comparator Interface to sort Employees by department
 * */
public class DepartmentCompare implements Comparator<Employee>{

	public DepartmentCompare() {
		super();
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getDepartment().compareTo(e2.getDepartment());
	}

}
