package com.revature.assignment1;

public class Question16 {

	public static void main(String[] args) {
		//The string entered in command line is "hello"
		System.out.println("There are " + countCharacters(args[0]) + " characters in your string '" + args[0] + "'");
	}
	
	//Return the length of the string
		//Length of string = number of characters
	public static int countCharacters(String str) {
		return str.length();
	}

}
