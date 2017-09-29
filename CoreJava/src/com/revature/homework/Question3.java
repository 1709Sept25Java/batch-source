package com.revature.homework;

public class Question3 {
	
	/*
	 * Reverse a string without using a temporary variable.  Do NOT use reverse() 
	 * in the StringBuffer or the StringBuilder APIs.
	 * */
	public static void main(String[] args) {
		
		String str1="erised";
		System.out.println("The Mirror of '"+ str1 + "'");
		System.out.println(str1+" reversed is:");
		
		String result = backwards(str1);
		System.out.println(result);
	}

	/*
	 * Function to reverse a String. A string as input, converts it to a
	 * Char array, performs the reverse, converts back to String and returns
	 * a string.
	 * */
	public static String backwards(String str) {
		
		str += " "; //add whitespace to the end of the string
		int n = str.length();
		char[] reverse=str.toCharArray(); 
		
		for(int i=0; i<(n/2); i++) {
			int j = n-1-i; //going through the string in the opposite direction
			
			reverse[j]=reverse[i]; //put the character in index i in the empty space
			//check if it is the last iteration of the loop
			if(i==(n/2)-1) { 
				reverse[i]=' '; //replace the repeat character with white space
			} else {
				//replace the character in the index i with the character in index
				//corresponding to original string length-1, this is safe because
				//the char index i has already been place at index j
				reverse[i]=reverse[j-1];
			}
		}
		
		String result = new String(reverse); //convert the char[] a string
		
		result= result.replaceAll("\\s", ""); //remove the white space added for the swap
		return result;
	}
}
