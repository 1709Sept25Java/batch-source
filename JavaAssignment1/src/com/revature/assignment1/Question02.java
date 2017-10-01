package com.revature.assignment1;

public class Question02 {
	public static void main(String[] args) {
		int [] fib = new int[25];
		Fibonacci(fib);
		print(fib);
	}
	
	public static void Fibonacci(int[] fib){
		//Base Case
		fib[0] = 0;
		fib[1] = 1;
		
		//Calculate Fibonacci using Fn = F(n-1)+F(n-2)
		for (int i=2; i<25; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
	}
	
	//Print array elements on one line
	public static void print(int[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}


