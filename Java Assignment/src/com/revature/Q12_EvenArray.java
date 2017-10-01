package com.revature;

public class Q12_EvenArray {
	//method to calculate the even numbers in a string of 100
	public static void main(String[] args) {
		int [] ar = new int [100];
		int index = 0;
		// fill with numbers between 1 and 100
		for (int i = 1; i <= 100; i++) { 
			ar [index] = i;
			index++;
		}
		//generate even number between 1 - 100
		for (int j: ar ) {
			if (j % 2 == 0) { 
				System.out.print(j + " ");
				}
			}
	}
}
