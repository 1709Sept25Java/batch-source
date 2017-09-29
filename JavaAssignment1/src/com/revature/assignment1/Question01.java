package com.revature.assignment1;

public class Question01 {
	public static void main(String[] args) {
		int [] arr = {1,0,5,6,3,2,3,7,9,8,4};
		BubbleSort(arr);
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void BubbleSort (int [] toSort) {
		for (int i=0; i<toSort.length; i++) {
			for (int j=0; j<toSort.length-i-1; j++) {
				if (toSort[j]>toSort[j+1]) {
					int tmp = toSort[j];
					toSort[j] = toSort[j+1];
					toSort[j+1] = tmp;
				}
			}
		}
	}
}
