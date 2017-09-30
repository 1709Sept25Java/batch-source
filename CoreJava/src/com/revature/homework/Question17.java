package com.revature.homework;

import java.util.Scanner;

public class Question17 {
	
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
		
		sc.close();
		
		System.out.println("The simple interest is: "+ principal*rate*time);
	}

}
