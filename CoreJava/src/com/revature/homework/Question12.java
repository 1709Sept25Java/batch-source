package com.revature.homework;

public class Question12 {

	/*
	 * Write a program to store numbers from 1 to 100 in an array. 
	 * Print out all the even numbers from the array. Use the enhanced 
	 * FOR loop for printing out the numbers.
	 * */
	
	public static void main(String[] args) {
		
		int[] numbs= new int[100]; //create array
		
		//Loop to assign values for int array
		for(int i=0; i<100; i++) {
			numbs[i]=i+1;
		}
		
		System.out.println("Even numbers between 1 and 100: ");
		
		//Loop to print Even numbers
		for(int i : numbs) {
			//Print number only if %2 is 0
			if((i%2)==0) {
				System.out.print(i+",");
			}
			//new line for nicer printing
			if(i==numbs.length/2) {
				System.out.println();
			}
		}
		
	}
	
}
