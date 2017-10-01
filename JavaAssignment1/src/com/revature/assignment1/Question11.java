package com.revature.assignment1;

//Import Variables class from another package
import com.revature.assignment1.question11.Variables;

public class Question11 {

	public static void main(String[] args) {
		
		Variables variables = new Variables();
		
		//Access variables from other package's class using get methods
		System.out.println("Variable 1: " + variables.getV1());
		System.out.println("Variable 2: " + variables.getV2());
		
	}
}
