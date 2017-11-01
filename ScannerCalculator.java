package com.revature.calculator;

import java.util.Scanner; // java utility package 

public class ScannerCalculator {

	public static void main(String[] args) {
		
		reader();
		
		
	}
	
	public static void reader(){
		
		double num1, num2, answer;
		Scanner myScanner = new Scanner(System.in); // build a scanner and parameter tells it where to get input from 
		System.out.println("Enter first number: ");
		num1 = myScanner.nextDouble(); 
		System.out.println("Enter second number: ");
		num2 = myScanner.nextDouble();
		answer = num1 + num2;
		System.out.println("The answer is: "+ answer);
		
		
		
		
	}
	
	
	// I didn't know how to use the two methods, particularly the add() with the specific signature 
	// I need to work on my understanding of the wrapper class, and structuring my code 

}