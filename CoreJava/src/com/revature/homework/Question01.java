package com.revature.homework;

public class Question01 {

	/*
	 * Perform a bubble sort of the integer array 1,0,5,6,3,2,3,7,9,8,4
	 * */
	public static void main(String[] args) {
		
		//create int array and instantiate it
		int[] toSort = new int[]{1,0,5,6,3,2,3,7,9,8,4};
		bubble(toSort); //call bubble sort function
		
		System.out.println("Sorted Array:");
		for(int i=0; i<toSort.length; i++) {
			//display the sorted array
			System.out.println(toSort[i]);
		}
	}
	
	/*
	 * Bubble: takes an integer array as input and performs bubble sort 
	 * */
	public static void bubble(int[] toSort) {
		
		int n=toSort.length;
		
		for(int i=0; i<n-1; i++) { 
			//loop through each spot on the array
			for(int j=i+1;j<n;j++) { 
				//loop through the all the spots after i
				if(toSort[j]<toSort[j-1]) {
					//compare the two spots next to each other
					//swap the values if the the left value > right value
					int temp= toSort[j]; 
					toSort[j]=toSort[j-1];
					toSort[j-1]=temp;
				}
			}
		}
	}
}
