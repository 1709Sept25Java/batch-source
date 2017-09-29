package com.revature.assignment1;

import java.util.*;

/*
 * TAKE CARE OF CLASS STRUCTURE - EVERYTHING IS ALL TOGETHER RIGHT NOW
 * 
 */
public class Question07 {
	public static class Employee {
		String name;
		String department;
		int age;
		
		public Employee() {
			super();
		}
		
		public Employee(String name, String department, int age) {
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		public String toString() {
	        return this.name + " " + this.department + " " + this.age;
	    }
	}
	
	public static class CompareByAge implements Comparator<Employee> {
		
		public int compare(Employee e1, Employee e2) {
			if (e1.age == e2.age) {
				return 0;
			}
			else if (e1.age>e2.age) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}
	
	public static class CompareByName implements Comparator<Employee> {
		public int compare (Employee e1, Employee e2) {
			return e1.name.compareTo(e2.name);
		}
	}
	
	public static class CompareByDepartment implements Comparator<Employee> {
		public int compare (Employee e1, Employee e2) {
			return e1.department.compareTo(e2.department);
		}
	}
	

	//http://www.geeksforgeeks.org/comparator-interface-java/
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Greg", "Math", 45));
		employees.add(new Employee("Fred", "Chemistry", 34));
		
		//Unsorted employees
		System.out.println("Unsorted: ");
		for (Employee e:employees) {
			System.out.println(e);
		}
		
		Collections.sort(employees, new CompareByName());
		System.out.println("\nSorted by Name: ");
		for (Employee e:employees) {
			System.out.println(e);
		}	
		
		Collections.sort(employees, new CompareByDepartment());
		System.out.println("\nSorted by Department: ");
		for (Employee e:employees) {
			System.out.println(e);
		}	
		
		Collections.sort(employees, new CompareByAge());
		System.out.println("\nSorted by Age: ");
		for (Employee e:employees) {
			System.out.println(e);
		}	
		
	}
	

}
