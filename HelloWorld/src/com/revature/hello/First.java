package com.revature.hello;
/*
 * Package - a name-space that organizes a set of related classes and interfaces 
 * corresponds to a folder structure 
 * base package for Java is java.lang
 */

import com.revature.oop.*; //save us typing, brings in the contents of a single package with wildcard(*)
import static java.lang.System.*; // gets all static members of the java.lang.system class

public class First {
	/*
	 * Naming conventions: SELF-DOCUMENTATION 
	 * classes & projects: pascal casing, FirstSecondThird
	 * methods & variables: camel casing, firstSecondThird
	 * package names: lowercase, separated by periods, e.g. com.revature.[other stuff]
	 * constants: Fisrt_Second_Third 
	 */
	static final String Company_Name = "Revature"; 
	/*
	 * static - affiliated with First, final - can't be changed
	 */
	
	/*
	 * Main Method: JVM looks for a method as an entrance point to the program 
	 */
	public static void main(String[] arg) {
		// Static: we don't need an instance of First to execute this method 
		// Void: return method, means nothing is returned by the main()
		// String[] args are the parameter passed to main()
		// sysout+crtl+space
		System.out.println("Hello World, we work for "+First.Company_Name);
		//compiling: converting .java source files to .class bytecode for execution by the JVM 
		//STS (and, under the hood Eclipse) used incremental compilation, every time a file is saved it and any files depending upon it is re-compiled  
		
		//to access Animal.jave, we need to give its fully qualifedclassname )package name + class name) or do an import at the top of the class
		//com.revature.oop.Animal a = new com.revature.oop.Animal("Fred"); import com.revature.oop.*;
		Animal a = new Animal("Fred");
		
		//using our static import 
		out.println("I'm using a static import to print this");
		
		//one public class per file, must share the name of the file, First.java
		
	}
}
