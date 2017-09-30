package com.revature.homework;

public class Question16 {

	public static void main(String[] args) {
		
		//Ensure that a command line argument was given
		if(args.length!=0) {
			String clArg = args[0];
			System.out.println("String length is: "+clArg.length()+" character.");
		} else {
			System.out.println("Command Line Argument Needed for this program!");
		}
		
	}
	
}
