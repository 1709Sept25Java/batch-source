package com.revature.assignment1;

public class Question16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("There are " + countCharacters(args[0]) + " characters in your string '" + args[0] + "'");
	}
	
	public static int countCharacters(String str) {
		return str.length();
	}

}
