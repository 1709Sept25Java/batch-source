package com.revature.assignment1;

public class FibonacciNum {

	public static void main(String[] args) {

		fibonacciNum();
	}

	public static void fibonacciNum() {

		int[] fibo = new int[26];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i < fibo.length; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		for (int j = 0; j < fibo.length; j++) {
			System.out.println(fibo[j] + " ");
		}

	}
}
