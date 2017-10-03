package com.revature.customeexception;

import java.util.Scanner;

public class CustomException {

	public static void main(String[] args) {
						calculator();
						
	}

	public static void calculator() {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a value for x");
		int x = input.nextInt();
		System.out.println("Enter a value for y");
		int y = input.nextInt();
		int addResult = add(x, y);
		
		int subResult = sub(x, y);
	
		int multResult = mult(x, y);
		
		System.out.printf("Add : %d; Sub :%d; Mult : %d\n", addResult, subResult, multResult);
		try {
			div (x,y);
		} catch (InvalidInputException e) {
			
			e.printStackTrace();

		}
		
		input.close();
	}

	public static int add(int a, int b) {

		return a + b;
	}

	public static int sub(int a, int b) {
		return a - b;
	}

	public static int mult(int a, int b) {
		return a * b;
	}

	public static void div(int a, int b) throws InvalidInputException {

		if (b==0) {
			throw new InvalidInputException ("\nDivisor is zero");
			}
		int result = a/b;
		System.out.println("Division : %d" +result);
		
	}

}
