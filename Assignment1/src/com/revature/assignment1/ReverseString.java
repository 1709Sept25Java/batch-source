package com.revature.assignment1;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {

		reverseString();
	}

	public static void reverseString() {

		Scanner scanner = new Scanner(System.in);
		String reverse = " ";
		System.out.println("Enter a string to be reversed: ");
		String s = scanner.nextLine();

		int l = s.length();

		for (int i = l - 1; i >= 0; i--) {

			reverse += s.charAt(i);

		}
		scanner.close();
		System.out.println(reverse.toString());

	}
}
