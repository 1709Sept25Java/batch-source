package com.revature.Hello;
  /* package - a namespace that organizes a set of related classes and interfaces
 * correspond to folder structure 
 * base package for Java is java.lang
 */

public class First {
/*
 * Naming conventions:
 * classes and projects: pascal casing, FirstSeconfThird
 * methods and variables: camel casing, firstScondThird
 * package names: lowercase, separated by period, e.g. com.revature. [other stuff]
 * constants:First_SECOND_THIRD
 * 
 * 
 * static - affiliate with first, final- can't be changed, String- datatype
 *  should be referenced with the name of the class
 */
static final String COMPANY_NAME = " Revature";

/*
 * Main method: JVM looks for method with this signature as an entrance point
 * to the program
 * 
 */
public static void main (String[] args){
	// static: we don't need an instance of First to excecute this method
	// void: return type. Mean that nothing is returned by main()
	// String[] args are the parameters passed to main()
	
	// sysout+ctrl+space
	System.out.println(" Hello World, we work for"+ First.COMPANY_NAME);

}

}

