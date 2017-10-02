package com.java.corejava;

import java.util.Scanner; //scanners are fun!!! 

public class Even {
	
	public static void main(String[] args) {
		
		Scanner checkNum = new Scanner(System.in);
		System.out.println("Enter a number to check if its even: ");
		int num = checkNum.nextInt(); 
		
		if ((num / 2) * 2 == num) {  // this is only working because I am using integer, it is not evaluating 0.0
			System.out.println("The number entered is even!");
			
		} else {
			System.out.println("The number entered is NOT even!");
			
		}	
			
	}
}


