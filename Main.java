package com.revature.bubblesort;

public class Main {
	
	public static void main(String[] args) {
		int[] arr1 = {3,6,2,9,1};
		System.out.println(Sort.bubbleSort(arr1));
		
		int[] arr2 = {3};
		System.out.println(Sort.bubbleSort(arr2));
		
		int[] arr3 = {3,6,2,9,1,0,3};
		System.out.println(Sort.bubbleSort(arr3));
		
	}

}
