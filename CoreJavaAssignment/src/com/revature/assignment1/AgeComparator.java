package com.revature.assignment1;

import java.util.*;

public class AgeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.age==e2.age)
		return 0;
		else if(e1.age>e2.age)
		return 1;
		else 
		return -1;
		}
	}
	

