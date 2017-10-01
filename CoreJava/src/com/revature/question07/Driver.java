package com.revature.question07;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

	public static void main(String[] args) {
		
		//create Employees and add them to a list
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Kim","Media",23));
		empList.add(new Employee("Eric","IT",56));
		
		//Print the list in its initial order
		System.out.println("Initial Employee List order: ");
		for(Employee e : empList){
			System.out.println(e);
		}
		
		//Create a NameCompare instance
		NameCompare nc = new NameCompare();
		Collections.sort(empList, nc); //use Collections to sort with NameCompare
		System.out.println("Employee List sorted by name: ");
		//Print the sorted list to console
		for(Employee e : empList){
			System.out.println(e);
		}
		
		//Create a Department compare instance
		DepartmentCompare dc = new DepartmentCompare();
		Collections.sort(empList, dc); //use Collections to sort using DepartmentCompare
		System.out.println("Employee List sorted by department: ");
		//Print the sorted list to console
		for(Employee e : empList){
			System.out.println(e);
		}
		
		//Create an AgeCompare instance
		AgeCompare ac = new AgeCompare();
		Collections.sort(empList, ac); //use Collections to sort using AgeCompare
		System.out.println("Employee List sorted by age: ");
		//Print the sorted list to console
		for(Employee e : empList){
			System.out.println(e);
		}
		
	}
	
}
