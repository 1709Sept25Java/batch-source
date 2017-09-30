package com.revature.homework;

import java.util.Scanner;

public class Question17 {
	
	/*
	 * Simple function that prompts the user for principal, rate, and time console
	 * input, then uses it to calculate the interest. The result is written to the console.
	 * */
	
	public static void main(String[] args) {
		
		double principal, rate, time;
		System.out.println("Please enter an the principal: ");
		
		//Create scanner for the console input
		Scanner sc= new Scanner(System.in);
		principal = Double.parseDouble(sc.nextLine()); //convert String input to double
		//get rate
		System.out.println("Please enter an the rate: ");
		rate = Double.parseDouble(sc.nextLine()); //convert String input to double
		//get time
		System.out.println("Please enter an the time: ");
		time = Double.parseDouble(sc.nextLine()); //convert String input to double
		//Close the scanner since no further console input it required
		sc.close();
		
		System.out.println("The simple interest is: "+ principal*rate*time);
	}

}
