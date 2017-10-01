package com.revature.assignment1;
import java.util.*;

public class NumberOfCharacterInString {

	public static int numberOfChars(String str) {
		int length = str.length();
		int count = 0;
		for (int i = 0; i < length; i++) {//traverse through string
			if (str.charAt(i) != ' ') {
				count++; //increment count for character
			}
		}
		return count;
	}
	
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a string: ");
		String str = s.nextLine();
		int num = numberOfChars(str);
		System.out.println(num);
		s.close();
	}

}
