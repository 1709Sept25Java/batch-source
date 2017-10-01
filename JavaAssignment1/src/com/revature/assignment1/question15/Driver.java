package com.revature.assignment1.question15;

public class Driver {
	public static void main(String[] args) {
		
		//Test values 
		int n1 = 45;
		int n2 = 3;
		
		//Create operations object 
		Operations operations = new Operations();
		
		//Call operations methods
		System.out.println("Addition \n" +n1 + " + " + n2 + " = " + operations.addition(n1, n2));
		System.out.println("\nMultiplication \n" + n1 + " * " + n2 + " = " + operations.multiplication(n1, n2)); 
		System.out.println("\nDivision \n"  + n1 + " ÷ " + n2 + " = " + operations.division(n1, n2)); 
	}
}
