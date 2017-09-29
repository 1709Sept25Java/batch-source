package com.revature.homework;

import java.util.ArrayList;
import java.util.Iterator;

public class Question08 {
	
	/*
	 * Write a program that stores the following strings in an ArrayList and saves 
	 * all the palindromes in another ArrayList.
	 * “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, 
	 * “billy”, “did”
	 * */
	
	public static void main(String[] args) {
		
		ArrayList<String> full= new ArrayList<String>();
		//I just didn't  want to type out add 11 times so I set up a loop to add the elements
		String[] temp= new String[] {"karan","madam","tom","civic","radar","jimmy",
				"kayak","john","refer","billy","did"};
		for(String s: temp) {
			full.add(s);
		}
		
		ArrayList<String> palins= new ArrayList<>();
		//Iterate through the full list of Strings
		Iterator<String> it=full.iterator();
		while(it.hasNext()) {
			String s= it.next();
			if(palinCheck(s)) {
				palins.add(s); //Add to the new list if the check returns true
			}
		}
		
		//Print full list
		System.out.println("The original ArrayList: ");
		System.out.println(full.toString());
		
		//Print only palindromes
		System.out.println("Only the palindromes: ");
		System.out.println(palins.toString());
		
	}
	
	/*
	 * Function to check if a String is a palindrome.
	 * Takes a String argument and returns true is the string is a palindome
	 * */
	public static boolean palinCheck(String test) {
		
		//A loop for half of the string length
		for(int i=0; i<(test.length()/2); i++) {
			//compare charAt i with char at StringLength-i
			//if the chars don't match no further checking is needed, return false
			if(test.charAt(i)!=(test.charAt(test.length()-1-i))) {
				return false;
			}
		}
		
		//if the loop completes return true
		return true;
	}

}
