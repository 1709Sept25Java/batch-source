package com.revature.homework;

public class Question06 {
	/*
	 * Write a program to determine if an integer is even without using the modulus operator
	 * */
	public static void main(String[] args) {
		int check = 20;
		boolean even=isEven(check);
		
		if(even) {
			System.out.println("Number is Even");
		} else {
			System.out.println("Number is Odd");
		}
	}	

	/*
	 * Function to check if a number is even without using %2
	 * Takes integer input and returns a boolean value
	 * */
	public static boolean isEven(int test) {
		
		//divide the input in half
		int half=test/2;
		
		if((half*2)==test) {
			//if the integer result of half*2 equals the integer given, the number us even
			return true;
		}
		//default return false
		return false;
	}
}
