package com.java.corejava;

import java.util.Arrays;

public class ArrayList19 {

	 public static void main(String args[]){
		 
	 
	        int anArray[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // create an integer array with numbers 1-10 (9 indexes) 
	        
	        System.out.println("In this Array: "+ Arrays.toString(anArray)+ "..."); //use java.util.Arrays .toString to print Array to console
	        
	        int even = 0, odd = 0; // place holders 
	        
	      
	       
	        for (int i = 0; i< anArray.length; i++){  // Loop to find even, odd sum with nested if-else 
	            if (i % 2 == 0)
	                even += anArray[i]; // if the integer has no remainder... move through the array and add 
	            else
	                odd += anArray[i];
	        }
	        
	     
	        System.out.println("All even numbers add up to: " + even);
	        System.out.println("All odd numbers add up to: " + odd);
	        System.out.println("The prime numbers in this array are:");
	        
	        for(int i = 2; i < anArray.length; i++){ // in the array above ...

                boolean isPrime = true;  
                
                for(int j = 2; j < i ; j++){   //check to see if the number is prime

                        if(i % j == 0){
                                isPrime = false;  
                                break;
                        }
                }
                
                if(isPrime)
                       System.out.print(i + " "); // print the number
        }
		
	 }
}






// Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
//Add all the even numbers up and display the result. Add all the odd numbers up and display the result. 
//Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
