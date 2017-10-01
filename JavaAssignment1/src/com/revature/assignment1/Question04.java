package com.revature.assignment1;

public class Question04 {
	

	public static void main(String[] args) {
		Integer number = 5;
		System.out.println("The calculated factorial of " + number + "! = " + nthFactorial(number));
	}

	public static int nthFactorial(int n) {
		//Initializing factorial to 1
		int factorial = 1;
		
		//Calculate factorial by multiplying 1*2*3...*n
		for (int i=1; i<=n; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
}
