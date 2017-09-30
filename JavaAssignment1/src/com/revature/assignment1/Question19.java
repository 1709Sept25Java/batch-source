package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Q19. Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. 
 * Add all the even numbers up and display the result. 
 * Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.

 */
public class Question19 {

	public static void main(String[] args) {

		ArrayList<Integer> integers = new ArrayList<Integer>();
		events(integers);
	}

	public static void events(ArrayList<Integer> list) {
		for (int i=1; i<=10; i++) {
			list.add(i);
		}
			
		printList(list);
		
		Integer sumEvenNumbers = 0;
		Integer sumOddNumbers = 0;
		
		for (Integer item:list) {
			if (item%2 == 0) {
				sumEvenNumbers += item;
			}
			else {
				sumOddNumbers += item;
			}
		}
		
		System.out.println(sumEvenNumbers);
		System.out.println(sumOddNumbers);
		
		Iterator<Integer> it = list.iterator();

		System.out.println(isPrime(1) + " 1");
		while(it.hasNext()) {
			 int number = it.next();
			 if (!isPrime(number)) {
				 it.remove();
			 }
		}

		for (Integer i:list) {
			System.out.println(i);
		}
		
		
	}
	
	public static void printList(ArrayList<Integer> list) {
		for (Integer i: list) {
			System.out.println(i);
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
}
