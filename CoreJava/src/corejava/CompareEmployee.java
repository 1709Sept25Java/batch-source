package corejava;

import java.util.Comparator;

class Employee{ //created employee class to store name, department, age for an employee
	String name;
	String department;
	int age; 
	
	public Employee(String name, String department, int age){ //constructor to create Employee object
		this.name = name;
		this.department = department;
		this.age = age;
	}
}

public class CompareEmployee implements Comparator<Employee>{
	
	public static int compare(String a, String b) { //compare method for strings 
		return a.compareTo(b);
	}
	
	public static int compare(int a, int b) { //compare method for int 
		return a - b;
	}
	
	public int compare(Employee o1, Employee o2) { //override method from comparator interface
		return 0; 
	}
	
	public static void main(String[] args) {
		Employee e1 = new Employee("Amy", "Math", 30); 
		Employee e2 = new Employee("Bob", "History", 45);
		System.out.print("Sorted by Name: ");
		System.out.println((compare(e1.name, e2.name) < 0) ? e1.name + " " + e2.name: 
			e2.name + " " + e1.name); //sort by name
		System.out.print("Sorted by Department: ");
		System.out.println((compare(e1.department, e2.department) < 0 ? e1.department + " " + e2.department: 
			e2.department + " " + e1.department)); //sort by department
		System.out.print("Sorted by Age: ");
		System.out.println((compare(e1.age, e2.age)) < 0 ? e1.age + " " + e2.age : e2.age + " " + e1.age); //sort by age

	}

}
