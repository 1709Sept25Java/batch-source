package com.revature.assignment1;

import java.util.Scanner;

public class SubStringMethod {

	public static void main(String[] args) {

		subStrMethod();
	}

	// This program prints all possible substrings of a given string

	public static void subStrMethod() {
		CharSequence subStr = " ";
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = input.nextLine();
		int length = str.length();

		for (int i = 0; i < length; i++) {
			for (int j = 1; j <= length - i; j++) {
				subStr = str.subSequence(i, j + i);
				System.out.println(subStr.toString());
				input.close();

			}
		}

	}
}
