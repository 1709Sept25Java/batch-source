package com.java.corejava;

import java.util.Scanner; 

//import java.util.Arrays;


public class FibonacciN {

	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		Scanner fibScanner = new Scanner(System.in);
		System.out.println("Enter the N Fibonacci number youd like to know:");
		int n = fibScanner.nextInt();
		
		int a = 0, b = 0, c = 1;
		
		for (int i = 1; i < n; i++) {
			a = b;
			b = c;
			c =  a + b;
		
			System.out.println(a +" ");
			//System.out.println("The " +n+ " number in the Fibonacci sequence is "+ a);
	        
			}
			
		
		 
	}
	
	

}
