package com.revature.hello;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] toSort = new int [4];
		toSort[0] = 1;
		toSort[1] = 3;
		toSort[2] = 10;
		toSort[3] = 5;
		bubbles(toSort);		
	}
	public static void bubbles(int[] toSort) {
		//sort any array of int values using the bubblesort algorithm 
		
		int a = toSort.length;
		int temp;
		for(int i = 0; i< a; i++) {
			for(int j = 1; j<a; j++) {
			if(toSort[j] < toSort[j-1]) {
				temp = toSort[j];
				toSort[j]= toSort[j-1];
				toSort[j-1] = temp;
				}
			}
		}
		for(int i = 0;i<a;i++) {
			System.out.print(toSort[i] + " ");
		}
	}

}
