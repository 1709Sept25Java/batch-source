package com.revature.assignment1;

import java.util.Scanner;

public class SimpleInterest {
	
	public static void main (String[] args) {
		
		float principal, rate, time;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the Principal : ");
		principal = s.nextFloat();//generate principal 
		
		System.out.println("Enter the Rate of Interest: ");
		rate = s.nextFloat();//generate rate 
		
		System.out.println("Enter the Time period: ");
		time = s.nextFloat();//generate time 
		
		float simpleInterest;
		simpleInterest =(rate*time*principal)/100;//call calculate the simple interest
		System.out.println("The Simple Interest is : " + simpleInterest);
		
	}

}
