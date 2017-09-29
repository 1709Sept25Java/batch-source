package com.revature.corejava;

import java.util.ArrayList;

public class Q8_PalindromeArrayList {

	public static void main(String[] args) {

		ArrayList<String> stringList = Array("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",
				"refer", "billy", "did");
		ArrayList<String> palindromesList = Palindromes(stringList);
		System.out.println(palindromesList);
	}

	public static ArrayList<String> Array(String a, String b, String c, String d, String e, String f, String g,
			String h, String i, String j, String k) {
		ArrayList<String> arr = new ArrayList<String>(); // creates an ArrayList with a method that takes 11 String
															// arguments
		arr.add(a);
		arr.add(b);
		arr.add(c);
		arr.add(d);
		arr.add(f);
		arr.add(g);
		arr.add(h);
		arr.add(i);
		arr.add(j);
		arr.add(k);
		return arr;
	}

	public static ArrayList<String> Palindromes(ArrayList<String> arr) {
		ArrayList<String> arrPal = new ArrayList<String>();
		for (String a : arr) {
			if (isPalindrome(a) == true) { // checks all elements of the ArrayList with the isPalindrome method
				arrPal.add(a); // adds the element to a new ArrayList of palindromes if the method returns true
			}
		}
		return arrPal;
	}

	public static boolean isPalindrome(String str) {
		if (str.length() == 1) { // if the word is a single character, it is automatically a palindrome
			return true;
		}

		double lettersToCheck; // determine the number of letters to check based on if the string has an odd or
								// even number of letters
		if (str.length() % 2 == 0) {
			lettersToCheck = (str.length() / 2); // for even, check half the word
		} else {
			lettersToCheck = (str.length() / 2) + .5; // for odd, the middle letter need not be checked
		}

		str = str.toUpperCase(); // convert string to all upper case letters so case is not an issue

		for (int i = 0; i < lettersToCheck; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) { // for loop checks first half letters
																		// against the other half
				return false; // if any of them are not the same, isPalindrome is false
			}
		}

		return true; // if it makes it out of the for loop, the words is a palindrome and method
						// returns true
	}

}
