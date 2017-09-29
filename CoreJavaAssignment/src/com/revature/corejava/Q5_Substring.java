package com.revature.corejava;

public class Q5_Substring {
	
	public static void main( String[] args) {
//		System.out.println(sub("Greetings",3));
//		System.out.println(sub("Serendipity",6));
//		System.out.println(sub("HelloWorld",5));
//		//test cases
	}
	
	public static String sub( String str, int lastIndex ) { //method inputs string you want to shorten
		char[] charArray = new char[lastIndex]; //creates an array
		for (int i = 0; i<lastIndex; i++) { //puts the characters of input string into array, up until the number specified
			charArray[i] = str.charAt(i);
		}
		return ArrayToString(charArray, lastIndex); //calls a method to return the array back to a string
	}

	public static String ArrayToString(char[] arr, int lastIndex) {
		String str = "";
		for (int i = 0; i<lastIndex; i++) { //loop concatenates characters in the array into a single strng
			str = str + arr[i];
		}
		return str;
			
	}
}
