package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Arrays;

public class Q19ArrayList {

	public static void main(String[] args) {
		createArraylist();

	}

	public static void createArraylist() {

		ArrayList<Integer> arrList = new ArrayList<Integer>(10);
		for (int i = 1; i <= 10; i++) {
			arrList.add(i);
		}
		int sumEven = 0;
		int sumOdd = 0;
		for (int n : arrList) {
			if (n % 2 == 0)
				sumEven += n;
			else
				sumOdd += n;
		}
		System.out.println("List: " + Arrays.toString(arrList.toArray()));
		System.out.println("Sum of the even numbers: " + sumEven);
		System.out.println("Sum of the odd numbers: " + sumOdd);

		System.out.println("\nRemoving prime number: ");
		for (int i = 1; i <= 10; i++) {
			if (checkPrime(i)) {
				arrList.remove(new Integer(i));
			}
		}

		System.out.println("List: " + Arrays.toString(arrList.toArray()));

	}

	static Boolean checkPrime(int number) {

		// only even prime
		if (number == 2) {
			return true;
		}

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
