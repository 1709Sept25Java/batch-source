package com.revature.assignment1;

public class FibonacciNum {

	public static void main(String[] args) {
	         
		
	          for (int i=0; i<=25; i++ ) {
	        	  System.out.println(i + ": " +fibonacciNum(i));
	          }
	          

	      
		

	}
	
		public static int fibonacciNum (int n) {
		     
			if ( n<=1) {
				return n;
			}
			else {
				return (n-1) + (n-2);
				
			}
			
		}
}
