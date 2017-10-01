package com.revature.question07;

import java.util.Comparator;

/*
 * Implements the Comparator Interface to sort Employees by name
 * */
public class NameCompare implements Comparator<Employee> {

	public NameCompare() {
		super();
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		
		return e1.getName().compareTo(e2.getName());
	}

}
