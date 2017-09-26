package com.revature.hello;
/* 
 * package- a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure 
 * base package for Java is java.lang
 */

public class First {
	
	/*
	 * Naming conventions: 
	 * classes and projects: pascal casing, FirstSecondThird
	 * methods and variables: camel casing, firstSecondThird
	 * package names: lowercase, separated by periods, e.g. com.revature.[other stuff]
	 * constants: FIRST_SECOND_THIRD
	 */
	
	/*
	 * static- affiliated with First, final- can't be changed, String- datatype
	 * should be referenced with the name of the class
	 */
	static final String COMPANY_NAME = "Revature";
	
	/*
	 * Main method: JVM looks for a method with this signature as an entrance point 
	 * to the program 
	 */
	public static void main (String[] args){
		//static: we don't need an instance of First to excecute this method
		//void: return type. Means that noting is returned by main() 
		//String[] args are the parameters passed to main() 
		
		//sysout+ctrl+space
		System.out.println("Hello World, we work for "+First.COMPANY_NAME);
		
		//why do we both with naming conventions? SELF-DOCUMENTATION!  
		
		//compiling: converting .java source files to .class bytecode for execution by the JVM
		//STS (and, under the hood, Eclipse) uses incremental compilation
		//this means, every time a file is saved, it and any files depending upon it is re-compiled. 
		
	}
	

}
