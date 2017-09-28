package com.revature.hello;

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] toSort = new int [4];
		toSort[0] = 1;
		toSort[1] = 5;
		toSort[2] = 2;
		toSort[3] = 8;
		
		bubbles(toSort);
	}
	public static void bubbles(int[] toSort) {
	//sort any array of int values using the bubblesort algorithm
		
		int i = toSort.length;
		int temp;
		for (int m=0; m < i; m++) {
			for (int j = 1; j < i; j++) {
				
				if(toSort[j - 1] > toSort[j]) {
					temp = toSort[j - 1];
					toSort[j - 1] = toSort[j];
					toSort[j] = temp;
				}
			}
		}
		for (int n=0; n< toSort.length; n++) 
			System.out.print(toSort[n]+ " ");
	}
	
	
}
