package com.revature.tuesday;

import java.util.Scanner;

public class ScannerCalculator {
	


		public static void main (String[] args) {
		
			
			read();
			
			

		}
		public static double add(double a, double b) {
		
		               return a + b;
		}
		    public static double sub(double a, double b) {
		    	       return a-b;
		    }
		    public static void read() {
		    	
		    	Scanner input = new Scanner(System.in);
				System.out.print("Enter a value for first number");
				double Number1 = input.nextDouble();
				System.out.println("Enter a value for second number");
				double Number2 = input.nextDouble();
				double addResult = add(Number1,Number2);
				//double subResult= sub(Number1,Number2);
			
				System.out.println(addResult); 
				
				input.close();
				}
		    	
		   
				 
		    	
		    }
	 



