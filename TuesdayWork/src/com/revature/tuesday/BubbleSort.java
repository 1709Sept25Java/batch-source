package com.revature.tuesday;

public class BubbleSort {

	public static void main(String[] args) {
		
		 int a [] = {1,0,5,6,3,2,3,7,9,8,4};
		 bubbleSort(a);
		
	        for (int k=0; k<a.length; k++) {
	            System.out.println(a[k]+ " ");
	        }
		 
}
	public static void bubbleSort(int [] sortArray) {
		
		int n= sortArray.length;
		for (int i=0; i<n-1; i++) {
			
			for (int j=0; j<n-i-1; j++) {
				
				if (sortArray[j] > sortArray[j+1]) {
					
					int temp = sortArray[j];
					sortArray[j]= sortArray[j+1];
					sortArray[j+1]= temp;
					
					
				}
				
			}
		}
	}
	

}
