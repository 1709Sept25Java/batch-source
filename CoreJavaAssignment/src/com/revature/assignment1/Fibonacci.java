package com.revature.assignment1;

public class Fibonacci {
	public static void main(String[] args) {
		
		//number of elements to generate 
		int limit = 25;
		
		long[] series = new long[limit];
		
		//create the first two series 
		series[0] = 0;
		series[1] = 1;
		
		//to create fibonacci series and store it as an array
		for (int i=2; i < limit; i++){
			series [i] = series [i-1] + series [i-2];
		}
		
		//print the fibonacci series 
		System.out.println("Diplay fibonacci number from 0 upto "+limit);
		for(int i=0; i<limit; i++)
		{
			System.out.print(series[i] + " ");
		}
	}

}
