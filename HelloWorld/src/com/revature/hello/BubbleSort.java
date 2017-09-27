package com.revature.hello;

public class BubbleSort {
	public static void main (String[] args) {
		int toSort[] = {5,1,12,3,20};
		
		for (int i=0; i<toSort.length-1; i++) {
			for (int j=i; j<toSort.length-1; j++) {
				if (toSort[i]>toSort[i+1]) {
					int tmp = toSort[i];
					toSort[i] = toSort[i+1];
					toSort[i+1] = tmp;
				}
			}
		}
		for (int i=0; i<toSort.length-1; i++) {
			System.out.println(toSort[i]);
		}
	}
	
	public static void bubbles(int[] toSort) {
		
		//sort any array of int values using the bubblesort algorithm
		for (int i=0; i<toSort.length; i++) {
			if (toSort[i]>toSort[i+1]) {
				int tmp = toSort[i];
				toSort[i] = toSort[i+1];
				toSort[i+1] = tmp;
			}
		}
	}
}
