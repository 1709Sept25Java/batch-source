package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrListPalindromes {

	public static void main(String[] args) {
		storeArrayList();
	}

	public static void storeArrayList() {
		String[] s = { "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did" };
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(s));

		for (int i = 0; i < list.size(); i++) {
			
			ArrayList<String> palindromeList = new ArrayList<String>();
			int wordLength = list.get(i).length();
			String leftSide = " ";
			String rightSide = " ";

			if (wordLength % 2 == 1) { // If word has odd number of characters.
				leftSide = list.get(i).substring(0, wordLength / 2);
				rightSide = list.get(i).substring((wordLength / 2) + 1, wordLength);

			} else { // If word has even number of characters.
				leftSide = list.get(i).substring(0, (wordLength / 2));
				rightSide = list.get(i).substring((wordLength / 2), wordLength);
			}
			String reversedLeftSide = new StringBuilder(leftSide).reverse().toString();
			if (reversedLeftSide.equals(rightSide)) {
				palindromeList.add(list.get(i));
				String palindrome = palindromeList.toString();
				System.out.println(palindrome);
			}

		}

	}
}
