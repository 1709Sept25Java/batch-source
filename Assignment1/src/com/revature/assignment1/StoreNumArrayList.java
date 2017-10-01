package com.revature.assignment1;

import java.util.ArrayList;

public class StoreNumArrayList {

	public static void main(String[] args) {

		storeNumArrayList();

	}

	public static void storeNumArrayList() {
		ArrayList<Integer> number = new ArrayList<Integer>(100);
		for (int i = 1; i <= 100; i++) {
			number.add(i);
		}
		for (int j = 2; j <= 100; j++) {
			if (checkPrime(j)) {
				System.out.println(number.get(j - 1));
			}
		}
	}

	public static boolean checkPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
