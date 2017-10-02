package com.java.corejava;

public class BubbleSort {

	public static void main(String[] args) {
		
		int number[]= {1,0,5,6,3,2,3,7,9,8,4}; // move through each index to compare it to index ahead  
		
		int temp; // once array number is deleted through swap
		
		boolean fixed = false;
		
		while (fixed == false) { // once the for loop runs once, 
		
		fixed = true; //dictates the termination of the if statement 
			
		for (int i = 0 ; i < number.length-1 ; i++) { //keep track of what index the loop is on 
			
			if (number[i] > number[i+1]) { // assorting  from least to greatest, if 1 > 5 ...perform a swap 
				
				temp = number[i+1]; //stores 1 in temp variable 
				number[i + 1] = number[i]; //puts the 0 in the fist index
				number [i] = temp; // creates first swap 
				fixed=false; //makes the while keep repeating 
				
				}
			
			} 
		
		}
		
		for(int i = 0; i<number.length; i++)	{ // finally prints sorted array 
			System.out.println(number[i]);
			
		}
	}
	
}
					
	
		
		





//Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4