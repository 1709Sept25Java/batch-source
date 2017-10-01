package com.revature.assignment1;
import java.util.ArrayList;
public class ArrayListPrimeNumber {
	public static void main(String [] args) {
		int max =100;
		
		System.out.println("Generate prime numbers between 1 and 100: ");
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//loop through the numbers one by one 
		for (int n=1; n<max; n++) {
			boolean prime = true; 
			
			//analyzes n for prime number 
			for (int i =2; i<n; i++) {
				if (n % i == 0) {
					prime = false;
					break; // exit the inner for loop
				}
				
			}
			if (prime && n !=1) {
				list.add(n);
			}
		}
		for (int j : list) {
			System.out.print(j + " ");
		}
	}

}
