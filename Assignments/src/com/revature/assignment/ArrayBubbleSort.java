package com.revature.assignment;

import java.lang.reflect.Array;

public class ArrayBubbleSort {
	
	public static void main(String [] args){
		int [] numbers = { 1,0,5,6,3,2,3,7,9,8,4};
		boolean swapped = false;
		do {
			swapped = false;
			for ( int j = 0; j <numbers.length -1 ; j++)
				 if (numbers[j] > numbers[j + 1]) {
					 int tmp = numbers[j + 1];
					 numbers[j + 1] = numbers[j];
					 numbers[j] = tmp;
					 swapped = true;
				 }
		} while (swapped);
		for ( int pos = 0; pos < numbers.length; pos++)
			System.out.print(numbers[pos]+" ");
		System.out.println();
	}
}
