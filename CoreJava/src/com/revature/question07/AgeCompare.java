package com.revature.question07;

import java.util.Comparator;

public class AgeCompare implements Comparator<Employee>{

	public AgeCompare() {
		super();
	}

	@Override
	public int compare(Employee e1, Employee e2) {
		Integer a1=e1.getAge();
		return a1.compareTo(e2.getAge());
	}

}
