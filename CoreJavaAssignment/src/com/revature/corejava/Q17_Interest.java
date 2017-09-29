package com.revature.corejava;

import java.util.Scanner;

public class Q17_Interest {
	
	public static void main( String[] args ) {
		interest(); //calls method that calculates interest
	}
	
	public static double interest() {
		Scanner scan = new Scanner(System.in); //opens scanner 
		System.out.println("Welcome to the interest calculator.");
		System.out.println("Please enter principal amount:");
		double p = Double.parseDouble(scan.nextLine()); //saves user input principal amount
		System.out.println("Please enter interest rate (in decimal form):");
		double r = Double.parseDouble(scan.nextLine()); //saves user input interest rate
		System.out.println("Please enter number of years:");
		double t = Double.parseDouble(scan.nextLine()); //saves user input number of years
		scan.close();
		double accruedAmount = p*(1+r*t); //implements interest rate function
		System.out.println("The accrued amount is $"+accruedAmount); //prints and returns accrued amount
		return accruedAmount;
	}

}
