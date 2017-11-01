package com.java.corejava;

import java.util.Scanner;

public class SimpleInterest {

	public static void main(String[] args) {
		
		Scanner principal = new Scanner(System.in);
		System.out.println("Enter Principal:");
		double p = principal.nextDouble();
		
		Scanner rate = new Scanner(System.in);
		System.out.println("Enter Rate:");
		double r = rate.nextDouble();
		
		Scanner time = new Scanner(System.in);
		System.out.println("Enter Time:");
		double t = principal.nextDouble();
		
		double interest = p*r*t;
		
		
		System.out.println("You're simple interest will be: " + interest);
	}

}



// Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
//Enter principal, rate and time through the console using the Scanner class.
//Interest = Principal* Rate* Time
