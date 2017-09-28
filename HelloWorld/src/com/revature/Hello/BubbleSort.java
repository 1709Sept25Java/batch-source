package com.revature.Hello;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class BubbleSort {
static void BubbleSort(int []array) {
	int n= array.length;
	int temporary = 0;
	for (int i= 0; i <n; i++)
	{
		for (int j= 1; j < n-1; j++)
		{
			if ( array[j-1] > array[j])
				temporary = array[j-1];
			array[j - 1] = array[j] ;
			array[j] = temporary ;
		}
	}
}

 public static void main(String[] args) {
	 
	 int array[] = { 6,9,12,40,37} ;
	 System.out.println(" Array before bubble sort"     );
	 for ( int i= 0; i < array.length;i++){
		 System.out.println(array[i]);
	 }
	for ( int i=0; i<array.length; i++){
		System.out.println("Array after bubble sort" );
		for (int j= 0; j <array.length; j++);
		System.out.println(array[i]);
	}
 }
 
 }