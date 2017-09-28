package com.ravature.hello;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int array[] =  {4,8,7};
		
		System.out.println();
		System.out.println(" array after bubble sort");
		//System.out.println;
		
		for (int i = 0; i< array.length;i++)
		{
			System.out.println(array[1]);
		}
	}
	public void bubbles(int[] array) {
	int n = array.length;	
	int temporary = 0;
	for( int i = 0;i < n; i++)
	{
		for (int j=1;j<(n-i);j++)
		{
			if (array[ j-1] > array[j])
				temporary = array[j-1];
			array[j-1]= array[j];
			array[j] = temporary;
			
			
		}
	}
	}

}
