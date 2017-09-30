package com.revature.assignment1.question15;

import com.revature.assignment1.Question15Class;

public class Driver {
	public static void main(String[] args) {
		int n1 = 45;
		int n2 = 3;
		Question15Class tester = new Question15Class();
		System.out.println("Addition: " + tester.addition(n1, n2));
		System.out.println("Multiplication: " + tester.multiplication(n1, n2)); 
		System.out.println("Division: " + tester.division(n1, n2)); 
	}
}
