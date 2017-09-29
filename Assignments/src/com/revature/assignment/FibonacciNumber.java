package com.revature.assignment;

public class FibonacciNumber {

	public static void main(String[] args) {
		
		
		 
		int limit = 25; 

		long[] block = new long[limit]; 

		//create first 2 series elements 
		block[0] = 0; // 
		block[1] = 1; 

		//create the Fibonacci series and store it in an array 
		for(int i=2; i < limit; i++) 
		{ 
		block[i] = block[i-1] + block[i-2]; 
		} 

		//print the Fibonacci  numbers 

		System.out.println("Fibonacci numbers upto " + limit); 
		for(int i=0; i< limit; i++) 
		{ 
		System.out.print(block[i] + " "); 
		} 
		} 
		//}
	}

//}
