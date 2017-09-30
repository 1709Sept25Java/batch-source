package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Iterator;

public class Question09 {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=1; i<=100; i++) {
			numbers.add(i);
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
		
	}
	static boolean isPrime(Integer n){
		if (n<2) {
			return false;
		}
		for (int i = 2; i<(n/2)+1; i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
	
//	static void primeNumbers(ArrayList<Integer> numbers, int i) {
//		Iterator<Integer> it = numbers.iterator();
//
//		while(it.hasNext()) {
//			 int number = it.next();
//
//			 if (number%i==0) {
//				 it.remove();
//			 }
//		}
//	}

	

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
	