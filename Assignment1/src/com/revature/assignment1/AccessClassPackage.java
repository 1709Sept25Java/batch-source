package com.revature.assignment1;

import com.revature.packagetobeaccessed.ClassTobeAccessed;

public class AccessClassPackage {

	public static void main(String[] args) {
		
		ClassTobeAccessed myClass = new ClassTobeAccessed();
		  
		System.out.println("First accessed float variable is:" +myClass.var1);
		System.out.println("Second accessed float variable is: " +myClass.var2);
		
		
	}

}
