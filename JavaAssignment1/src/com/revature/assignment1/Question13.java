package com.revature.assignment1;

public class Question13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printTree();
	}

	public static void printTree() {
		int value = 0;
		for (int i=0; i<4; i++) {
			for (int j=0; j<(i+1); j++) {
				if (value==0) {
					System.out.print(value + " ");
					value = 1;
				}
				else {
					System.out.print(value + " ");
					value = 0;
				}
			}
			System.out.println();
		}
	}
}
