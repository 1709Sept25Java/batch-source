package com.revature.hello;
/*
 * package: a namespace that organizes a set of related classes and interfaces 
 * corresponds to a folder structure 
 * base package for Java is java.lang 
 */

import com.revature.oop.*;
//this just saves us typing
//Brings in contents of a single package with wildcard (*)
import static java.lang.System.*; //gets all static members of the java.lang.System class

public class First {
	
	/*
	 * Naming conventions:
	 * Classes and Projects: Pascal Casting
	 * 	- ie. FirstSecondThird
	 * 	- capitalize first letter of each word
	 * Methods and Variables: Camel Casting
	 * 	- first letter is not capitalize, others are
	 * 	- ie. firstSecondThird
	 * Package:
	 * 	- lowercases
	 * 	- separated by periods
	 * 	- ie. com.revature.{other stuff}
	 * Constants:
	 * 	- ALL CAPS
	 * 	- ie. FIRST_SECOND_THIRD 
	 */
	
	/*
	 * static: affiliated with First
	 * final: can't be changed
	 * String: datatype
	 * should be referenced by the name of class
	 */
	static final String COMPANY_NAME = "Revature";
	
	/*
	 * Main method: JVM looks for a method with this signature as an entrance point
	 * to the program 
	 */ 
	public static void main(String[] args) {
		//static: we don't need an instance of First to execute this method
		//void: return type - means nothing is returned by main()
		//String[] args are the parameters passed to main()
		
		//sysout+ctrl+space
		System.out.println("Hello World, we work for " + First.COMPANY_NAME);
		
 		
		//compiling: converting .java source files to .class bytecode for execution by the JVM
		//STS (and, under the hood, Eclipse) uses incremental compilation 
		//this means, every time a file is saved, it and any files depending upon it is re-compiled. 
		
		//to access Animal.java, we need to give its fully qualified classname 
		//(package name + class name)
		//OR! do an import at the top of the class 
		//com.revature.oop.Animal a = new com.revature.oop.Animal("Fred");
		
		out.println("I'm using a static import to print this");//static import is used 
		
		//one public class per file, must share name of the file 
	}
	
	

}
