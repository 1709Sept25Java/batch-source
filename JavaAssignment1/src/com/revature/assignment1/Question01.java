package com.revature.assignment1;

public class Question01 {
	public static void main(String[] args) {
		int [] array = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Prior to sorting: ");
		print(array);
		BubbleSort(array);
		System.out.println("\nAfter sorting: ");
		print(array);
	}
	
	public static void BubbleSort (int[] toSort) {
		//Iterate through array of items to sort
		for (int i=0; i<toSort.length; i++) {
			//Compare adjacent members and swap if out of order
			//j = length - i - 1 because the largest element is carried to the last position
				//so we don't need to check it again
			for (int j=0; j<toSort.length-i-1; j++) {
				if (toSort[j]>toSort[j+1]) {
					//Store the value at j into a temp variable to avoid losing it
					int tmp = toSort[j];
					toSort[j] = toSort[j+1];
					toSort[j+1] = tmp;
				}
			}
		}
	}
	
	//Print array elements on one line
	public static void print(int[] array) {
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
