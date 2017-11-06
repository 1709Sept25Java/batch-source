package com.revature.driver;

import java.util.Scanner;

import com.revature.calculator.Calculator;

public class Driver {

	public static void main(String[] args) {
		
		Scanner x = new Scanner(System.in);
		int a,b;
		String operation;
		
		System.out.println("Enter first number:");
		a = x.nextInt();
		System.out.println("Enter second number:");
		b = x.nextInt();
		System.out.println("Enter operation (add, subtract, multiply or divide):");
		operation = x.nextLine();
		x.close();
		
		Calculator c = new Calculator();
		
		switch (operation) {
		case "add": {
			System.out.println(c.add(a, b));
			break;
		}
		
		case "subtract": {
			System.out.println(c.subtract(a, b));
			break;
					}
		
		case "multiply": {
			System.out.println(c.multply(a, b));
			break;
		}
		
		case "divide": {
			System.out.println(c.divide(a, b));
			break;
		}
	}
	
	}


}
