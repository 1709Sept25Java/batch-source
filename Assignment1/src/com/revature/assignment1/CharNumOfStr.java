package com.revature.assignment1;

import java.util.HashMap;

public class CharNumOfStr {

	public static void main(String[] args) {
		String s = "this is problem number 16";
		s.toLowerCase();
		charCount(s);
	}

	public static void charCount(String str) {

		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

		char[] strArray = str.toCharArray();

		for (char character : strArray) {
			if (charCountMap.containsKey(character)) {

				charCountMap.put(character, charCountMap.get(character) + 1);
			} else {
				charCountMap.put(character, 1);
			}
		}

		System.out.println(charCountMap);
	}

}