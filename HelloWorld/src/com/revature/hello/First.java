package com.revature.hello;
/*
 * Package- a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang
 * */

import com.revature.oop.*;
//this brings in contents of a single package with wildcard (*)- all in com.revature
//import static= import all the static members of a class


public class First {
	
	/*
	 * Naming Conventions:
	 * Classes and projects: pascal casing, FirstSecondThird
	 * Methods and variables: camel casing, firstSecondThird
	 * Package names: lowercase, separated by periods, e.g. com.revature.[other stuff]
	 * Constants: FIRST_SECOND_THIRD (no constant keyword use 'static final'
	 * 
	 * Naming Conventions= Self-documentation, keeps consistency
	 * */

	/*
	 * static- affiliated with first, final- can't be changed
	 * */
	static final String COMPANY_NAME = "Revature";
	
	/*
	 * Main method: JVM looks for a method with this signature as an entrance point
	 * to the program
	 * */
	public static void main(String[] args) {
		//static:we don't need an instance of First to execute this method
		//void: return type, nothing is returned by main()
		//String[] args are the parameters passed to main()
		
		System.out.println("Hello World");
		
		//compiling: converting .java source files to .class bytecode for execution by the JVM
		//STS (and eclipse) uses incremental compilation
		//means every time a file is saved, it and any files depending upon it is re-compiled.
		
		//to access Animal.java, we need to give its fully qualified classname
		//(package name +class name)
		//OR! do an import at the top of the class
		Animal a= new Animal("Fred");
		
		//one public class per file, must share name of the file
	}
}
