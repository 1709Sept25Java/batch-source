package com.revature.assignment1;

public class Question12 {
	public static void main(String[] args) {
		int[] array = new int[100];
		
		//Populate array
		for (int i=0; i<100; i++) {
			array[i] = i+1; 
		}
		
		System.out.println("Printing even numbers: ");
		printEvenNumbers(array);
		

	}
	public static void printEvenNumbers(int[] array) {
		for (int i: array) {
			//Use modulus to determine if a number is even
				//No remainder mean it's an even number
			if (i%2 == 0) {
				System.out.println(i);
			}
		}
	}
}
