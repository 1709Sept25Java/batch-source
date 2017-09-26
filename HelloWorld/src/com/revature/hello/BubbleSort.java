package com.revature.hello;

public class BubbleSort {

	public static void main(String [] args) {
		int[] toSort = new int[4];
		toSort[0] = 5;
		toSort[1] = 7;
		toSort[2] = 6;
		toSort[3] = 4;
		bubbles(toSort);
		
	}
	
	public static void bubbles(int[] toSort) {
		//sort any array of int values using the bubblesort algorithm 
		int j = toSort.length; 
		for(int i = 0; i < j; i++) {
			for(int k = 1; k < j; k++) {
				if(toSort[k] < toSort[k-1]) {
					int temp = toSort[k-1];
					toSort[k-1] = toSort[k];
					toSort[k] = temp;
				}
			}
	}
	
	for(int i = 0; i < j; i++) {
		System.out.print(toSort[i] + " ");
	}
}
}
