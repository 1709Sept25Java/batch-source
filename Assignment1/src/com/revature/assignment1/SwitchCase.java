package com.revature.assignment1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {

		switchCases();
	}

	public static void switchCases() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Pick one of the following choices: ");
		System.out.println("1. Find the square root of a number");
		System.out.println("2. Display today's date");
		System.out.println("3. Split the string");
		int i = scanner.nextInt();

		switch (i) {

		case 1:

			System.out.println("Enter an integer to find it's root: ");
			Double number = scanner.nextDouble();
			System.out.println("The square root of " + number + " is " + Math.sqrt(number));
			break;

		case 2:

			DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			System.out.println(sdf.format(date));
			break;

		case 3:

			String s = "I am learning Core Java";
			String[] splitStr = s.split("\\s");
			for (String str : splitStr) {
				System.out.println(str);
			}
			break;
		}
		scanner.close();
	}

}
