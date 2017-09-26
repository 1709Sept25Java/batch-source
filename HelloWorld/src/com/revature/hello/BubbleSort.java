package com.revature.hello;

//Rebeca and Massiel

public class BubbleSort {

	public static void main(String[]args) {
		
		int[] testArr = new int[4];
		testArr[0]=7;
		testArr[1]=2;
		testArr[2]=9;
		testArr[3]=0;
		
		bubbles(testArr);
		
		for(int i=0; i<4; i++) {
			System.out.println(testArr[i]);
		}
		
	}
	
	public static void bubbles(int[] toSort) {
		//sort any array of int values using the bubble sort algorithm
		int n = toSort.length;
	
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(toSort[j]<toSort[j-1]) {
					int temp=toSort[i];
					toSort[i]=toSort[j];
					toSort[j]=temp;
				}
			}
		}
		
	}
}
