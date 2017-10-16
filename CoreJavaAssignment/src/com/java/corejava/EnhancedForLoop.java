package com.java.corejava;

public class EnhancedForLoop {

	public static void main(String[] args) {
		
		int one = 1;
		int array[]; // empty array containing integers 
		
		array = new int[100];  // array containing 100 indexes
		
		for (int item : array) {
			item = item+one++; // each index is increased by an additional 1 each time 
			
			if(item % 2 == 0 ) { // and printed only if it meets the even conditions! 
			
			System.out.println(item);
			
			}
		}
		
	}

}





//Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
//Use the enhanced FOR loop for printing out the numbers.


