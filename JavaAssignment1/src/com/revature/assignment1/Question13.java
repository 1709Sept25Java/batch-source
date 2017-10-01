package com.revature.assignment1;

public class Question13 {

	public static void main(String[] args) {
		printTree();
	}

	public static void printTree() {
		//Variable value will be the value printed on the console
		int value = 0;
		
		//The tree we will print has 4 lines 
		for (int i=0; i<4; i++) {
			
			//At each line we will print one more value than previously
			for (int j=0; j<(i+1); j++) {
				
				//The value we print will switch back & forth between 0 & 1 
				if (value==0) {
					System.out.print(value + " ");
					value = 1; //switch 0 -> 1
				}
				else {
					System.out.print(value + " ");
					value = 0; //switch 1 -> 0
				}
			}
			System.out.println();
		}
	}
}
