package com.revature.tuesday;

public class BubbleSort {

	public static void main(String[] args) {
		
		 int a [] = {64, 34, 25, 12, 22, 11, 90};
		 bubbleSort(a);
		 
	        for (int i=0; i<a.length; i++)
	            System.out.println(a[i] + " ");
	        
		 
	
		

	}
	public static void bubbleSort(int [] sortArray) {
		
		int l= sortArray.length;
		for (int i=0; i<l-1; i++) {
			
			for (int j=0; j<j-i-1; j++) {
				
				if (sortArray[j] > sortArray[j+1]) {
					int temp = sortArray[j];
					sortArray[j]= sortArray[j+1];
					sortArray[j+1]= temp;
					
					
				}
				
			}
		}
	}
	

}
