package com.revature.assignment1;

import java.util.ArrayList;

public class Question08 {
	public static void main(String[] args) {
		ArrayList<String> possiblePalindromes = new ArrayList<String>();
		
		populate(possiblePalindromes);
		
		ArrayList<String> palindromes = palindromeCheck(possiblePalindromes);
		
		print(palindromes);
	}
	
	
	public static ArrayList<String> palindromeCheck(ArrayList<String> possiblePalindromeList) {

		//Confirmed palindromes will saved into another list
		ArrayList<String> palindromes = new ArrayList<String>(); 
		
		//Iterate through each word in the possible palindrome list
		for (String p: possiblePalindromeList) {
			
			//isPalindrome is a boolean set to true unless the word 
				//doesn't pass our check
			boolean isPalindrome = true;
			
			//We are going to check half the word with its matching other half
				//Middle value will be checked against itself if odd # of chars
			for (int i=0; i<p.length()/2; i++) {
				
				//Check if characters match working towards the center -> <-
					//if characters don't match then it is not a palindrome
				if (p.charAt(i) != p.charAt(p.length()-i-1)) {
					isPalindrome = false;
				}
			}
			
			//After checking entire word, we add to our confirmed palindrome list
				//if isPalindrome remains true
			if (isPalindrome == true) {
				palindromes.add(p);
			}
		}
		
		return palindromes; //confirmed palindromes
	}
	
	//Print elements of palindrome list
	public static void print(ArrayList<String> palindromes) {
		System.out.println("There are " + palindromes.size() + " palindromes found: ");
		for (String p:palindromes) {
			System.out.println(p + " ");
		}
	}
	
	//Adds elements to possible palindrome list
	public static void populate(ArrayList<String> possiblePalindromes) {
		possiblePalindromes.add("karan");
		possiblePalindromes.add("madam");
		possiblePalindromes.add("tom");
		possiblePalindromes.add("civic");
		possiblePalindromes.add("radar");
		possiblePalindromes.add("jimmy");
		possiblePalindromes.add("kayak");
		possiblePalindromes.add("john");
		possiblePalindromes.add("refer");
		possiblePalindromes.add("billy");
		possiblePalindromes.add("did");
	}
}