package com.revature.scanner;

import java.util.Scanner;

	public class ScannerCalculator {
		
		public static void main(String[] args)
		{
			int num1=0;
			int num2=0;
			char operator;
			double answer=0.0;
			
			Scanner scanObject = new Scanner(System.in);
			
			
			System.out.println("Please enter first number: ");
			num1 = scanObject.nextInt();
			System.out.println("Please enter second number: ");
			num2 = scanObject.nextInt();
			System.out.println("What operation? ");
			operator = scanObject.next().charAt(0);
			
			switch (operator) {
				case '+': answer = num1 + num2;
					break;
				case '-': answer = num1 - num2;
					break;
				case '*': answer = num1 - num2;
					break;
				case '/': answer = num1 - num2;
					break;
				default:
					System.out.println("Invalid Operator Used");	
				}
			
			System.out.println(num1+" "+operator+" "+num2+"="+answer);
				
		}
		//I confused using the datatype method and the operator method, I realized at the 
		//end that what I should have used was the datatype method. 
}
