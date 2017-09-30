package com.revature.question07;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {
		
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Kim","Media",23));
		empList.add(new Employee("Eric","IT",56));
		
		System.out.println("Initial Employee List order: ");
		for(Employee e : empList){
			System.out.println(e);
		}
		
		NameCompare nc = new NameCompare();
		Collections.sort(empList, nc);
		System.out.println("Employee List sorted by name: ");
		for(Employee e : empList){
			System.out.println(e);
		}
		
		DepartmentCompare dc = new DepartmentCompare();
		Collections.sort(empList, dc);
		System.out.println("Employee List sorted by department: ");
		for(Employee e : empList){
			System.out.println(e);
		}
		
		AgeCompare ac = new AgeCompare();
		Collections.sort(empList, ac);
		System.out.println("Employee List sorted by age: ");
		for(Employee e : empList){
			System.out.println(e);
		}
		
	}
	
}
