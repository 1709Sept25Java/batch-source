package com.revature.assignment1;

public class Question12 {
	public static void main(String[] args) {
		int[] arr = new int[100];
		for (int i=0; i<100; i++) {
			arr[i] = i+1; //i+1 because we are starting at index 0 
		}
		for (int i: arr) {
			if (i%2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
