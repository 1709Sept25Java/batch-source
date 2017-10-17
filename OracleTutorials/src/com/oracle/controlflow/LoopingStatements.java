package com.oracle.controlflow;

public class LoopingStatements {
	
	public static void main(String[] args) {
		
		int num = 0;
		while (num < 5) { //continually executes a block of statements while a particular condition is true
			System.out.println("while count is: " + num );
			num++;	
		} 
	
		 
		
		
		int count = 0;
	        do {
	            System.out.println("Do-while count is: " + count);
	            count++;
	        } while (count < 5); // the statements within the do block are always executed at least once.
	   
	       
	        
	        
	        
	        
	        for(int i=1; i<5; i++){ // repeatedly loops until a particular condition is satisfied.
	              System.out.println(" For count is: " + i);
	         } 
	        
	        
	        
	        
	        
	        int[] numbers = 	{0,1,2,3,4};						// enhance for loop
	         for (int item : numbers) {
	             System.out.println("Enhanced for-loop count is: " + item);
	         }
	
	
	
	
	}
}
