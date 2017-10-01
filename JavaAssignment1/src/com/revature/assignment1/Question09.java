package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Iterator;

public class Question09 {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		printPrimeNumbers(numbers);
	}
	
	public static boolean isPrime(Integer n){
		//Base Case 
		if (n<2) {
			return false;
		}
		
		//We only need to check half the numbers n could be divisible by 
			//because the other half of possible numbers is a multiple of the first half
		for (int i = 2; i<(n/2)+1; i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void printPrimeNumbers(ArrayList<Integer> numbers) {
		//Iterate numbers 1 to 100 and check each to see whether it is prime
		for(int i=1; i<=100; i++) {
			
			//All numbers will be stored into array
				//Note: Decided check whether a number is prime as we store the number
			numbers.add(i);
			
			//Only print out the number if it's prime
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
}

















////static ArrayList<Integer> primeNumbers(ArrayList<Integer> numbers) {
//		Iterator<Integer> it = numbers.iterator();
//		while(it.hasNext()) {
//			Integer n = it.next();
//			if (n==1) {
//				it.remove();
//			}
//			else {
//				for (int i=n+1; i<numbers.size(); i++) {
//					System.out.println(n + " " + i);
//					if (i%n == 0) {
//						
//					}
//					
//				}
//				System.out.println();
//			}
//		}
//		return numbers;
//	}
	