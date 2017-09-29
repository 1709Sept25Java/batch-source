package com.revature.assignment1;

public class Question04 {
	public static void main(String[] args) {
		System.out.println(nthFactorialLoop(5));
	}
	public static int nthFactorial(int n) {
		if (n==0) {
			return 1;
		}
		return n * nthFactorial(n-1);
	}

	public static int nthFactorialLoop(int n) {
		int factorial = 1;
		for (int i=1; i<=n; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}
}
