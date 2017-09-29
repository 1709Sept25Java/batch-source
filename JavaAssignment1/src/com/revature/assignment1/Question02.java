package com.revature.assignment1;

public class Question02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] fib = new int[25];
		fib[0] = 0;
		fib[1] = 1;
		for (int i=2; i<25; i++) {
			fib[i] = fib[i-1] + fib[i-2];
			//System.out.println(fib[i]);

		}
		
		for (int i=0; i<25; i++) {
			System.out.print(fib[i] + " ");
		}
	}

}
