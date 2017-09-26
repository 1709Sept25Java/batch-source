package com.revature.hello;
/*
 * package: a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang
 * */

import com.revature.oop.*;
//This just saves us typing. Brings in contents of a single package with wildcard (*)

import static java.lang.System.*; //gets all static members of the java.lang system class

public class First {
	/* 
	 * Naming conventions: 
	 * Classes and projects: pascal casing, FirstSecondThird
	 * Methods and variables: camel casing, firstSecondThird
	 * Package names: lowercase, separated by periods, eg. com.revature.[other stuff]
	 * Constants: FIRST_SECOND_THIRD
	 */

	/*
	 * static - affiliated with First, final - can't be changed, String - datatype
	 * should be referenced with the name of the class
	 */
	static final String COMPANY_NAME = "Revature"; 
	
	/*
	 * Main method: JVM looks for a method with this signature as an entrance point
	 * to the program
	 */
	
	public static void main (String[] args) {
		/* We don't need an instance of first to execute this method
		*  void: return type. Means that nothing is returned by main()
		*  String[] args are the parameters passsed to main()
		*/
		
		//sysout+ctrl+space
		System.out.println("Hello World, we work for" + First.COMPANY_NAME);
		
		//Why do we bother with naming conventions? Self-Documentation!
		
		//Compiling: converting .java source files to .class bytecode for execution by the JVM
		//Failed compilation: Was unable to convert your code to bytecode because it violates some language rule
		//STS (and, under the hood, Eclipse) uses incremental compilation
		//this means, every time a file is saved, it and many files depending upon it is re-compiled
		
		/*
		 * to access Animal.java, we need to give its fully qualified classname
		 * (package name + class name)
		 * OR do an import at the top of the class
		 */
		
		//com.revature.oop.Animal = new com.revature.oop.Animal("Fred");
		
		Animal a = new Animal("Fred"); 
		
		//using our static import
		//out.println("Using a static import to print this");
		
		//one public class per file, must share name of the file
		
	}
}
