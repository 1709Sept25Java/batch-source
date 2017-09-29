package com.revature.corejava;

public class Q13_TrianglePrint {

	public static void print() {
		int character = 1;
		for (int j = 1; j < 5; j++) { //loops for each row
			for (int i = 0; i < j; i++) { //make sure each row has the number of characters as its number of row
				if (character == 1) { //if statement alternates 0/1
					character = 0;
					System.out.print(character + " ");
					continue;
				}
				if (character == 0) {
					character = 1;
					System.out.print(character + " ");
				}
			}
			System.out.println();//creates a new line after the row is completed
		}
	}

	public static void main(String[] args) {
		print(); //calls the print function, printing out the triange
	}
}
