package com.revature.hello;

public class ToUpperCase {

	public static void main(String[] args) {
		String str = "apple";
		System.out.println(str.toUpperCase()); //returns a string where each letter of the string is capitalized 
		
		/*
		 * How I would implement it:
		 * - write a switch case for each letter corresponding to its upper case letter
		 * - do a for loop to traverse through each letter in the string
		 * - use the switch case for each letter and then concatenate each new uppercase letter together 
		 * 	into a new string 
		 * 
		 * OR
		 * - add 32 to the letter and cast it a char
		 * - concatenate all uppercase letters together 
		 */
	}

}
