package com.revature;

public class Q1_BubbleSort {
	//method to calculate a bubblesort
	public static void main(String[] args) {
		//array created for these numbers: 1,0,5,6,3,2,3,7,9,8,4
		int[] toSort = new int [11];
		toSort[0] = 1;
		toSort[1] = 0;
		toSort[2] = 5;
		toSort[3] = 6;
		toSort[4] = 3;
		toSort[5] = 2;
		toSort[6] = 3;
		toSort[6] = 7;
		toSort[8] = 9;
		toSort[9] = 8;
		toSort[10] = 4;
		
		bubbles(toSort);
	}
	public static void bubbles(int[] toSort) {
		
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
