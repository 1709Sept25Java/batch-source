package com.revature.assignment1.question07;

import java.util.Comparator;

public class NameCompare implements Comparator<Employee>{
	
	public NameCompare() {
		super();
	}
	
	public int compare(Employee e1, Employee e2) {
		String n1 = e1.getName();
		return n1.compareTo(e2.getName());
	}
}
