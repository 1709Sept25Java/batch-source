package com.revature.assignment1.question07;

import java.util.Comparator;

public class AgeCompare implements Comparator<Employee>{
	
	public AgeCompare() {
		super();
	}
	
	public int compare(Employee e1, Employee e2) {
		Integer a1 = e1.getAge();
		return a1.compareTo(e2.getAge());
	}
}
