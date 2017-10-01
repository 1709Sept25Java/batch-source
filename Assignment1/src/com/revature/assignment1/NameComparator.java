package com.revature.assignment1;

import java.util.*;

public class NameComparator implements Comparator<Object>  {

	
	public int compare(Object o1, Object o2) {
		
		Employees e1 = (Employees) o1;
		Employees e2 = (Employees) o2;
         
		return e1.name.compareTo(e2.name);
	}
	
	

}
