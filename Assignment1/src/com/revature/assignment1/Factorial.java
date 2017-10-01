package com.revature.assignment1;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number :");
		int number = scanner.nextInt();
		System.out.println("The factorial of the number is: " + Nfactorial(number));
		scanner.close();
	}

	public static Integer Nfactorial(int n) {

		if (n == 0) {

			return 1;
		} else {

			return n * (Nfactorial(n - 1));

		}

	}

}
