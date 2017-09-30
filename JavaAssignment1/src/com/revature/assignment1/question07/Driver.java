package com.revature.assignment1.question07;

import java.util.ArrayList;
import java.util.Collections;


public class Driver {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Greg", "Math", 45));
		employees.add(new Employee("Fred", "Chemistry", 34));
		
		//Unsorted employees
		System.out.println("Unsorted: ");
		for (Employee e:employees) {
			System.out.println(e);
		}
		
		AgeCompare a1 = new AgeCompare();
		NameCompare n1 = new NameCompare();
		DepartmentCompare d1 = new DepartmentCompare();
		
		Collections.sort(employees, n1);
		
		System.out.println("\nSorted by Name: ");
		for (Employee e:employees) {
			System.out.println(e);
		}	
		
		Collections.sort(employees,d1);
		System.out.println("\nSorted by Department: ");
		for (Employee e:employees) {
			System.out.println(e);
		}	
		
		Collections.sort(employees, a1);
		System.out.println("\nSorted by Age: ");
		for (Employee e:employees) {
			System.out.println(e);
		}	

	}

}
