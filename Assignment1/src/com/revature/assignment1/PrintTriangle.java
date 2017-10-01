package com.revature.assignment1;

public class PrintTriangle {

	public static void main(String[] args) {
		printTriangle();
	}

	public static void printTriangle() {

		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print((i + j) % 2 == 0 ? "1 " : "0 ");
			}
			System.out.println("");
		}
	}

}
