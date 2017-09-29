package com.revature.corejava;

import java.util.ArrayList;

public class Q12_Evens {

	public static void main(String[] args) {
		printEvens(100); //calls printEvens method which returns an array with numbers 1 to 100
	}

	public static ArrayList<Integer> printEvens(int size) {
		ArrayList<Integer> nums = new ArrayList<Integer>(size); //creates an ArrayList of input size
		for (int i = 1; i < size + 1; i++) {
			nums.add(i); // adds numbers 1-size
		}

		for (int n : nums) {
			if (n % 2 == 0) { //iterates through the ArrayList, when the  (n % 2 == 0) condition is met, the numebr is even
				System.out.print(n + " "); 
			}
		}

		return nums;//returns the array of numbers 1-100
	}

}
