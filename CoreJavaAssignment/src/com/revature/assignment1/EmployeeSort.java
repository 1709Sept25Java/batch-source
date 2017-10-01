package com.revature.assignment1;
import java.util.*;
import java.io.*;

public class EmployeeSort {
	public static void main(String [] args) {
		ArrayList<Employee> al=new ArrayList<Employee>();
		al.add(new Employee(" Josh ", " A ",  32));
		al.add(new Employee(" Jenn ", " B ", 60));
		
		//sort Employee by name 
		System.out.println("Sorting by name...");
		Collections.sort(al,new NameComparator());
		for(Employee em: al) {
			System.out.println(em.name+" "+em.department+"  "+em.age);
		}
		// sort employee by age 
		System.out.println("sorting out by age...");
		Collections.sort(al, new AgeComparator());
		for (Employee em: al) {
			System.out.println(em.name+ " "+em.department+" " +em.age);
		}
		//sort by department
		System.out.println("Sorting by department...");
		Collections.sort(al, new DepartmentComparator());
		for(Employee em:al) {
			System.out.println(em.name+ " " + em.department+ " " + em.age);
		}
	}

}
