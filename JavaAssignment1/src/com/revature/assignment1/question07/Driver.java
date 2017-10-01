package com.revature.assignment1.question07;

import java.util.ArrayList;
import java.util.Collections;


public class Driver {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("Greg", "Math", 32));
		employees.add(new Employee("Fred", "Chemistry", 45));
		
		//Unsorted employees
		System.out.println("Unsorted: ");
		print(employees);
		
		//Declare comparators that will be used to sort employees
		AgeCompare a1 = new AgeCompare();
		NameCompare n1 = new NameCompare();
		DepartmentCompare d1 = new DepartmentCompare();
		
		//Sort employees by name
		Collections.sort(employees, n1);
		System.out.println("\nSorted by Name: ");
		print(employees);	

		//Sort employees by department
		Collections.sort(employees,d1);
		System.out.println("\nSorted by Department: ");
		print(employees);

		//Sort employees by age
		Collections.sort(employees, a1);
		System.out.println("\nSorted by Age: ");
		print(employees);

	}
	
	//Print function to print employee information
	public static void print(ArrayList<Employee> employees) {
		for (Employee e:employees) {
			System.out.println(e);
		}
	}

}
