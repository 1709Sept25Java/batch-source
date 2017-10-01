package com.revature.assignment1;

public class EnhanceForLoop {

	public static void main(String[] args) {
		int [] ar = new int [100];
		int index = 0;
		for (int i = 1; i <= 100; i++) { // fill with numbers between 1 and 100
			ar [index] = i;
			index++;
		}
		for (int j: ar ) {
			if (j % 2 == 0) { //generate even number between 1 - 100
				System.out.print(j + " ");
				}
			}
	}
}
	
		

	


