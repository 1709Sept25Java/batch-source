package com.java.package2;

import com.java.package1.ContainsFloatVariables;

public class AccessFloatVariable extends ContainsFloatVariables { // through inheritance, this class can access 
	
	static float var3 = var1 + var2; // static var3 allows accessibility to the main method below

	public static void main(String[] args) {
		
		System.out.println(var3);

	}

}


//Write a program that would access two float-variables from a class that exists in another package.
//Note, you will need to create two packages to demonstrate the solution.