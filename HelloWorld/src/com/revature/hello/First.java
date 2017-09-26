package com.revature.hello;
/*
 * package: a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for Java is java.long
 */
//import com.revature.oop.*;
//this just saves us typing. brings in contents of a single package 
//import static java.lang.system.*; 
public class First {
	
	/*
	 * naming conventions: 
	 * classes and projects: pascal casing, FirstSecondThird
	 * methods and variables: camel casing, firstSecondThird
	 * package names: lowercase, separated by periods, e.g. com.revature.[other stuff]
	 * constants: FIRST_SECOND_THIRD
	 */
	
	/*
	 * Main Method: JVM looks for method with this signature as an entrance point 
	 * to the program
	 */
	/*
	 * static: affiliated with First, final- can't be changed, String - datatype 
	 * should be referenced with the name of the class 
	 */
	static final String COMPANY_NAME = "Revature";
	public static void main (String[] args) {
		// static: we dont need an instance of First to execute this method
		//void return type: means that nothing is returned  by main()
		//String[] args are the parameters passed to main()
		
		//sysout +ctrl+space
		System.out.println("Hello World, we work for " + First.COMPANY_NAME);
		
		//why do we bother with naming conventions? self-documents!
		//compiling: converting .java source files to .class bytecode for execution by the JVM 
		//STS (and, under the hood, Eclipse) uses incremental complication
		//this means, every time a file is saved, it and any files depending upon it is re-complied
		
		//to access Animal.java, we need to give its fully qualified classname
		//(package name + class name)
		//or! do an import at the top of the class
		//com.revature.oop.Animal a = new com.revature.oop.Animinal()"Fred)"
		//Animal a = new Animal ("Fred");
		//using our static import 
		//out.println("im using a static import to print this");
		//one public class per file, must share name of the file
	}

}
