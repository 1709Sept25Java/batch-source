package com.revature.homework;

import java.util.ArrayList;

public class Question8 {
	
	/*
	 * Write a program that stores the following strings in an ArrayList and saves 
	 * all the palindromes in another ArrayList.
	 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, 
	 * “billy”, “did”
	 * */
	
	public static void main(String[] args) {
		
		ArrayList<String> full= new ArrayList(11);
		String[] temp= new String[] {"karan","madam","tom","civic","radar","jimmy",
				"kayak","john","refer","billy","did"};
		for(String s: temp) {
			full.add(s);
		}
	}
	
	public static void palinList(ArrayList<String> full) {
		
	}
	
	public static boolean palinCheck(String test) {
		
		for(int i =0; i<(test.length()/2); i++) {
			if(test.charAt(i)==test.charAt(test.length()-i)) {
				return false;
			}
		}
		
		return true;
	}

}
