package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Iterator;


public class Question19 {

	public static void main(String[] args) {

		ArrayList<Integer> integers = new ArrayList<Integer>();
		sequenceOfEvents(integers);
	}

	public static void sequenceOfEvents(ArrayList<Integer> list) {
		
		//Populate list with integers 1 to 10
		for (int i=1; i<=10; i++) {
			list.add(i);
		}
			
		//Print the list
		System.out.println("The values in your list: ");
		printList(list);
		
		//Add all even numbers and all odd numbers
		Integer sumEvenNumbers = 0;
		Integer sumOddNumbers = 0;
		
		
		//Iterate through all numbers in the list 
		for (Integer item:list) {
			
			//If there is no remainder then it is an even number
				//Add the number to the sumEvenNumbers variable
			if (item%2 == 0 ) {
				sumEvenNumbers += item;
			}
			
			//If there is a remainder then it is an odd number
				//Add the number to the sumOddNumbers variable
			else {
				sumOddNumbers += item;
			}
		}
		
		//Print the sum of even numbers and odd numbers to console
		System.out.println("The sum of all the even numbers: " + sumEvenNumbers + "\n");
		System.out.println("The sum of all the odd numbers: " + sumOddNumbers + "\n");
		
		
		//Remove prime numbers from the list
			//We will use an iterator to safely remove values
		Iterator<Integer> it = list.iterator();

		//Iterate through list checking until we reach the end of the list
		while(it.hasNext()) {
			
			//Current value we are looking at
			int number = it.next();
			
			//Call isPrime function 
				//Remove only if it is not a prime number
			if (!isPrime(number)) {
				it.remove();
			}
		}

		System.out.println("Prime numbers in your list: ");
		printList(list);
		
	}
	
	//Print function prints all values in the list
	public static void printList(ArrayList<Integer> list) {
		for (Integer i: list) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}
	
	//Method to check if number is prime
	//Note: Same method as in Question 9
	static boolean isPrime(Integer n){
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
}
