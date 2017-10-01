package com.revature.assignment1;

public class PrintEvenArray {

	public static void main(String[] args) {

		storeArray();
	}

	public static void storeArray() {
		int[] arr = new int[100];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		for (int j = 0; j < arr.length; j++) {
			if (checkEven(j)) {
				System.out.println(arr[j + 1]);
			}
		}
	}

	public static boolean checkEven(int number) {
		if ((number & 1) == 0) {
			return true;
		}
		return false;

	}

}
