package com.revature.hello;
 
 //Rebeca and Massiel
 
 public class BubbleSort {
 
 	public static void main(String[]args) {
 		
 		int[] bubArray = {1,0,5,6,3,2,3,7,9,8,4};
 		bubbles(bubArray);
 		
 		for(int i=0; i<11; i++) {
 			System.out.println(bubArray[i]);
 		}
 		
 	}
 	
 	public static void bubbles(int[] toSort) {
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

 