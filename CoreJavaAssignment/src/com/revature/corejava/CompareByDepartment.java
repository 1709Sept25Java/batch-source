package com.revature.corejava;

import java.util.Comparator;

public class CompareByDepartment implements Comparator<Q7_Employee>  {

	@Override
	public int compare(Q7_Employee emp1, Q7_Employee emp2) {
		return emp1.dpt.compareTo(emp2.dpt);
	}

	//overrides the compare method in the comparator interface
	//compares department strings, returns a number indicating lexicographical relationship
}
