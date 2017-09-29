package com.revature.homework;

public class Question05 {

	/*
	 * Write a substring method that accepts a string str and an integer idx and 
	 * returns the substring contained between 0 and idx-1 inclusive.  Do NOT use 
	 * any of the existing substring methods in the String, StringBuilder, or 
	 * StringBuffer APIs.
	 * */
	public static void main(String[] args) {
		
		String str="Look at the sky, there's a great big heart there.";
		System.out.println("Initial string: '"+ str +"'");
		
		String sub=substring(str,15);
		System.out.println("Substring: "+ sub);
	}
	
	public static String substring(String str, int idx) {
		
		String sub="";
		
		for(int i=0; i<idx; i++) {
			sub += str.charAt(i);
		}
		
		return sub;
	}
}
