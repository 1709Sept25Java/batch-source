package com.revature.homework;

public class Question16 {

	
	/*
	 * Simple function to print the length of a String that is given in
	 * the command line
	 * */
	public static void main(String[] args) {
		
		//Ensure that a command line argument was given
		if(args.length!=0) {
			String clArg = args[0]; //access the string
			//print String argument length to console
			System.out.println("String length is: "+clArg.length()+" character.");
		} else {
			//Print message to console is not command line argument is given
			System.out.println("A Command Line Argument is Needed for this program!");
		}
		
	}
	
}
