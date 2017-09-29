package com.revature.corejava;

import java.util.Comparator;

public class CompareByName implements Comparator<Q7_Employee>  {

	@Override
	public int compare(Q7_Employee emp1, Q7_Employee emp2) {
		return emp1.name.compareTo(emp2.name);
	}
	//overrides the compare method in the comparator interface
	//compares name strings, returns a number indicating lexicographical relationship
}
