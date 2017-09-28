package com.revature.homework;

public class Question4 {
	
	/*
	 * Write a program to compute N factorial.
	 * */
	public static void main(String[] args) {
		
		int n=10;
		int result=fact(n);
		System.out.println("The factorial of "+n+" is: "+result);
	}
	
	/*
	 * Function to compute the factorial of a given int
	 * */
	public static int fact(int n) {
		
		int result=n; //int to store the result (the passed number remains the same)
		
		for(int i=1; i<n;i++) { //loop through the numbers 0 through n-1 inclusive
			result = result*i; //set result equal to its current value times i
		}
		
		return result;
	}

}
