//Question 7
import java.util.*;
import java.io.*;

public class Employee implements Comparable <Employee>{
	 String name;
	 String dept;
	 int age;
	
	public Employee(String name, String dept, int age) {
		this.name = name;
		this.dept=dept;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setDept(String dept) {
		this.dept=dept;
	}
	public String toString() {
		return "Name: " +getName()+ " Dept: " + getDept() + " Age: " + getAge();
	}
	
	public int compareTo(Employee employee) {
		return name.compareTo(employee.getName());
	}
	
}
