package com.revature.homework;

import java.util.ArrayList;
import java.util.Iterator;

public class Question19 {

	public static void main(String[] args) {
		
		//Create an integer array list and loop to add 1-10 to the array
		ArrayList<Integer> intList = new ArrayList<>();
		for(int i=0; i<10;i++) {
			intList.add(i+1);
		}
		//Print the array list to console
		System.out.print("ArrayList: ");
		for(int i : intList) {
			System.out.print(i+" ");
		}
		
		//Call the addEven and addOdd functions and print the results to console
		System.out.println("Sum of evens is: "+ addEven(intList));
		System.out.println("Sum of odda is: "+ addOdd(intList));
		
		//Instantiate an iterator and use a while loop to iterate through the list
		Iterator<Integer> it = intList.iterator();
		while(it.hasNext()) {
			int test=it.next();
			if(isPrime(test)) { //call isPrime and remove from list if return true
				it.remove();
			}
		}
		
		//Print the final version of the array list to the console
		System.out.print("ArrayList without Primes: ");
		for(int i : intList) {
			System.out.print(i+" ");
		}
		
	}
	
	
	/*
	 * Function to add all the even numbers in and integer array list.
	 * Takes and integer array list and returns and int value
	 * */
	public static int addEven(ArrayList<Integer> l) {
		
		int sum=0; //stores the sum
		//loop through the list items
		for(int i : l) {
			if(i%2==0) { //add to the sum if divisible by 2
				sum+=i;
			}
		}
		
		return sum;
	}
	
	/*
	 * Function to add all the odd numbers in and integer array list.
	 * Takes and integer array list and returns and int value
	 * */
	public static int addOdd(ArrayList<Integer> l) {
		
		int sum=0; //stores the sum
		//loop through the list items
		for(int i : l) {
			if(i%2>0) { //add to the sum if not divisible by 2
				sum+=i;
			}
		}
		
		return sum;
	}
	
	/*
	 * Prime Checker from Question 9
	 * */
	public static boolean isPrime(int n) {
		//if statement to skip the loop if the number is one of the first prime numbers
		if(n==1||n==2||n==3) {
			return true;
		} else if(n%2==0) { //skip the loop if number is even
			//already know that's it's not prime
			return false;
		}
		
		for(int i=3;i<n/2;i++) {
			//if n is divisible by i then return false
			if(n%i==0) {
				return false;
			}
		}
		
		//if the loop completes the number must be prime
		return true;
	}
}
