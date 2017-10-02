package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Sort two employees based on their name, department, and age using the Comparator interface.

public class Question_7
{
	private String name;
	private String department;
    private int age;
    
	public static void main (String []args) 
	{
		Question_7 q7=new Question_7();	
	}
	
	
	public List Employee(String name, String department, int age)
	{
		/**
		 name: employee1  department: dept1   age: 5  
		 name: employee2  department: dept2   age: 20  
		 **/
		this.setName(name);
		this.setDepartment(department);
		this.setAge(age);
		return Employee(name, department, age);
	}
	
	public static void sortEmployee()
	{	
		ArrayList<Employee> al=new ArrayList<>(); 
		al.add(new Employee("employee1","dept1",5));
		al.add(new Employee("employee2","dept2",20));
		//Collections.sort(al);
		//System.out.println(al);	
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	

}
