package com.revature.assignment1;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Array before Bubble Sort");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		BubbleSort(arr);
		
		System.out.println("Array after Bubble Sort");
		for (int i=0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}

	}

	private static void BubbleSort(int[] arr) {
		
		int n = arr.length;  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arr[j-1] > arr[j]){  
                                 //swap elements  
                                 temp = arr[j-1];  
                                 arr[j-1] = arr[j];  
                                 arr[j] = temp;  
                         }  
                          
                 }  
         }  
  
    }  
	
}


