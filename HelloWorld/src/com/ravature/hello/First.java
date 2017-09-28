package com.ravature.hello;
/*
 * package a namespace that organize a set of classes and interfaces
 * correspond to a folder structure
 * base package for JAva is java.lang
 * */
import com.ravature.oop.*;
//this just save us typing. Brings in contents of a single package with wildcard(*)
import static java.lang.System.*;

public class First {
	/*
	 * naming convention
	 * classes and project: pascal casing, FisrtSecondThird
	 * methods and variable: camel casing, firstSecondThird
	 * package names: lowercase, separated by periods, e.g. com.revature.[other stuff]
	 * constants: FIRST_SECOND_THIRD
	 */
	/*
	 * STATIC - affiliated with first, final
	 */
	static final String COMPANY_NAME = "REVATURE";
	/*
	 * main method: JVM looks for a method with this signature as an entrance point
	 * to the program
	 */
	public static void main (String[] args) {
		//static : we don't need an instance of first to excecute this method
		//void: return type. Mean that nothing is returned by main()
		//String[] args are the parameters passed to main()
		
		//Sysout+ctrl+space
		System.out.println("Hello World, we work for "+First.COMPANY_NAME);
		
		// WHY DO WE BOTHER EITH NAMING COMVENTION? SELFT-DOCEMENTED!
		
		//compiling: converting .java source file to .class bytecode for execution by the JVM
		//STS (and , under the hood, Eclipse) uses incremental compilation)
		// this mean, every time a file saved, it  and any file depending upon it is re-compiled.
		
		//to access Animal.java, we need to give its fully quallified classname
		//package name + calss name
		//OR! do an import at the top of the class
		com.ravature.oop.Animal a = new com.ravature.oop.Animal("Fred");
		Animal  =  new *Animal("Fred");
		out.println("i am using a static import to print this");
		
		//one public class per file, must share name of the file
		
	}
	
}
