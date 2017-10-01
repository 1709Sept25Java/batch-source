package com.revature.assignment1;

public class NFactorial {
	//factorial of N is the product of all positive descending integer
	// factorial of N is denoted by n!

	public static void main(String[] args) {
		int i,fact=1;
	
		int num=7;//number to calculate the factorial
		for (i=1;i<num;i++) {
			fact=fact*i;
		}
		System.out.println("Factorialof "+num+" is: "+fact);
	}

}
