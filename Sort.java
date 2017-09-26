package com.revature.bubblesort;

public class Sort {

	public static String bubbleSort(int[] arr) {

		for (int j=0; j<arr.length; j++) {
			for (int i=0; i<(arr.length-1); i++) {
				if (arr[i]>arr[i+1]) {
					int holder = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = holder;
				}
			}
		}
		return printArray(arr);
		
	}
	
	public static String printArray(int[] arr) {
		String str = "";
		for (int i=0; i<arr.length; i++) {
			str = str +" "+ arr[i];
		}
		return str;
	}
}
