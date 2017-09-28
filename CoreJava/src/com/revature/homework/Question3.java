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
		
		backwards(str1);
		System.out.println(str1);
	}

	/*
	 * */
	public static String backwards(String str) {
		
		str += " "; //concatenate whitespace to the end of the string
		int n = str.length();
		
		for(int i=0; i<n; i++) {
			int j = n-1-i;
			
			
		}
		
		return str;
	}
}
