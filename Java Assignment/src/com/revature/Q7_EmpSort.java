package com.revature;
import java.util.Arrays;
import java.util.Comparator;

public class Q7_EmpSort {
	
	//method for sorting employees by name, department and age
	public static void main(String args[]) {
		Student student[] = new Student[4];

		student[0] = new Student();
		student[0].setName("Nick");
		student[0].setDepartment("Science");
		student[0].setAge(21);

		student[1] = new Student();
		student[1].setName("Helen");
		student[1].setDepartment("Math");
		student[1].setAge(23);
		
		student[2] = new Student();
		student[2].setName("Ross");
		student[2].setDepartment("Science");
		student[2].setAge(23);
		
		student[3] = new Student();
		student[3].setName("Susan");
		student[3].setDepartment("Math");
		student[3].setAge(23);

		System.out.println("Order of students before sorting is: ");

		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].getName() + "\t"
					+ student[i].getDeparment());
		}

		Arrays.sort(student, new NameComparator());
		System.out
				.println("Order of students after sorting by student department is");

		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].getName() + "\t"
					+ student[i].getAge());
		}

		Arrays.sort(student, new AgeComparator());
		System.out
				.println("Order of students after sorting by student age is");

		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].getName() + "\t"
					+ student[i].getAge());
		}
	}	
	}
