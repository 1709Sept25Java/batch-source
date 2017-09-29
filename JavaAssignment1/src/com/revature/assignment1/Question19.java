package com.revature.assignment1;

import java.util.ArrayList;

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
		
		
		
	}
	
	public static void printList(ArrayList<Integer> list) {
		for (Integer i: list) {
			System.out.println(i);
		}
	}
}
