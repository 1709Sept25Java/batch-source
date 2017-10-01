package com.revature.assignment;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeTest {

	public static void main(String[] args) {
			
		  
		   public  EmployeeTest (int,String, int) {
			   
 Employee e1 = new Employee (1, "Franck",  32 );
 Employee e2 = new Employee (2, "James",  22);		    
 Employee e3 = new Employee (3, "Zenobia",  42);
 Employee e4 = new Employee (4, "Mohammad", 39);
		      
 List<Employee> listOfEmployees = new ArrayList<Employee>();
 listOfEmployees.add(e1);
 listOfEmployees.add(e2);
 listOfEmployees.add(e3);
 listOfEmployees.add(e4);
 
 System.out.println("Unsorted List : " + listOfEmployees);
		      
 Collections.sort(listOfEmployees);      //Sorting by natural order
 assertEquals(e1, listOfEmployees.get(0));
 assertEquals(e4, listOfEmployees.get(3));
		      
  Collections.sort(listOfEmployees, Employee.NameComparator);
  assertEquals(e1, listOfEmployees.get(0));
  assertEquals(e4, listOfEmployees.get(4));
		      
 Collections.sort(listOfEmployees, Employee.AgeComparator);
		       
 assertEquals(e2, listOfEmployees.get(0));

 assertEquals(e3, listOfEmployees.get(4));
		      
		       
 Collections.sort(listOfEmployees, Employee.departmentComparator);
 assertEquals(e3, listOfEmployees.get(0));
 assertEquals(e2, listOfEmployees.get(4));
		      
		        
		    }
		}


	}


