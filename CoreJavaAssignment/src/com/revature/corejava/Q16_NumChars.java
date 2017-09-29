package com.revature.corejava;

import java.util.Scanner;

public class Q16_NumChars {
	
	public static void main( String[] args ) {
		stringNums(); //calls method that finds number of characters in a user input string

	}
	
	public static int stringNums() {
		Scanner scan = new Scanner(System.in); //creates a scanner
		System.out.println("Enter your string:"); //prompts user to enter a string
		String str = scan.nextLine(); //saves user input
		System.out.println("Your string has "+str.length()+" characters"); //calculates and returns length of input
		scan.close(); //closes scanner
		return str.length(); //returns length
	}
	

}
