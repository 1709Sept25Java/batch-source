package com.revature.assignment1;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		InterfaceOperation test = new InterfaceOperation();

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the first number for calculation: ");
		Double n1 = input.nextDouble();
		System.out.println("Enter the second number for calculation: ");
		Double n2 = input.nextDouble();

		System.out.println("Addition : " + test.addition(n1, n2));
		System.out.println("Subtraction : " + test.subtraction(n1, n2));
		System.out.println("Multiplication : " + test.multiplication(n1, n2));
		System.out.println("Division : " + test.division(n1, n2));
		input.close();
	}

}
