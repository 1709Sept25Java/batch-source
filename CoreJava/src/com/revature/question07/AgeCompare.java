package com.revature.question07;

import java.util.Comparator;

/*
 * Implements the Comparator Interface to sort Employees by age
 * */

public class AgeCompare implements Comparator<Employee>{

	public AgeCompare() {
		super();
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		Integer a1=e1.getAge(); //Set as Integer to resolve autoboxing issues
		return a1.compareTo(e2.getAge());
	}

}
