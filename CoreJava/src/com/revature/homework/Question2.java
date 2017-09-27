package com.revature.homework;

public class Question2 {

	//Write a program to display the first 25 Fibonacci numbers beginning at 0
	
	public static void main(String[] args) {
		
		int last=0, curr=1; //integers to store the previously calculated values 
		int next; //int to store the calculation
		
		System.out.println("Fibonacci Sequence: ");
		System.out.println(0); //0 is given so print outside loop
		
		for(int i=0; i<25; i++) {
			//loop for calculation, needs to be run 
			System.out.println(curr); //print out Fibonacci number from last calculation
			next=last+curr; //calculation
			last=curr; //update values for next pass
			curr=next;
		}
	}
	
}
