package com.revature.assignment1;

import java.util.ArrayList;

public class Question08 {
	public static void main(String[] args) {
		ArrayList<String> possiblePalindromes = new ArrayList<String>();
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
		
		ArrayList<String> palindromes = palindromeCheck(possiblePalindromes);
		System.out.println(palindromes.size());
		for (String p:palindromes) {
			System.out.println(p + " ");
		}
	}
	public static ArrayList<String> palindromeCheck(ArrayList<String> possiblePalindromeList) {
		ArrayList<String> palindromes = new ArrayList<String>();
		for (String p: possiblePalindromeList) {
			//System.out.println(p + " " + p.length() + " " + p.length()/2);
			boolean isPalindrome = true;
			for (int i=0; i<p.length()/2; i++) {

				if (p.charAt(i) != p.charAt(p.length()-i-1)) {
					isPalindrome = false;
				}
			}
			if (isPalindrome == true) {
				palindromes.add(p);
			}
		}
		return palindromes;
	}
}