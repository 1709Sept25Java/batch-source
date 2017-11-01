package com.java.comparator;

import java.util.Comparator;

import com.revature.staff.Employee;
//import com.revature.staff.NewYorkStaff;


public class Compare implements Comparator<Employee>{

	public Compare(){
		
	}
	
	public int compare(Employee m1, Employee m2){
		String year1 = m1.getName();
		return year1.compareTo(m2.getName());
	}

}


