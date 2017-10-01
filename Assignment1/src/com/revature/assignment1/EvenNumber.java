package com.revature.assignment1;

import java.util.Scanner;

public class EvenNumber {

	public static void main(String[] args) {
		findEven();

	}

	public static void findEven() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int number = input.nextInt();
		if ((number / 2) * 2 == number) {

			System.out.print(+number + " is even");
		} else {
			System.out.println(+number + " is odd");
		}
		input.close();
	}

}
