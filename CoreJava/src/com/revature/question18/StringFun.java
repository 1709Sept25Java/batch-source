package com.revature.question18;

/*
 * Inheriting class of Stringy. Implements checkUpper, makeUpper, and addTen
 * */
public class StringFun extends Stringy {

	/*
	 * Takes a string argument, checks the String for Uppercase characters
	 * and returns true if one is found.
	 * */
	@Override
	public boolean checkUpper(String str) {
		
		for(int i=0;i<str.length();i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				return true; //ends function and return true if uppercase char is found
			}
		}
		
		//return false if the loop comepletes
		return false;
	}

	/*
	 * Takes a String argument, converts to the string to all uppercase letters
	 * and returns the altered string.
	 * */
	@Override
	public String makeUpper(String str) {
		
		String allUpper = str.toUpperCase(); //set all the letters to uppercase
		
		return allUpper;
	}

	/*
	 * Takes a string argument and converts the string to an integer then adds 10
	 * and prints the result to the console
	 * */
	@Override
	public void addTen(String str) {
		
		int n = Integer.parseInt(str) +10;
		
		System.out.println(str+" + 10 = "+n);
		
	}

}
