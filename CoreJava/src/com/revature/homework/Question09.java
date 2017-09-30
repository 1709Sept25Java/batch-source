package com.revature.homework;

import java.util.ArrayList;

public class Question09 {

	/*
	 * Create an ArrayList which stores numbers from 1 to 100 and prints out all
	 *  the prime numbers to the console.
	 * */
	
	public static void main(String[] args) {
		
		//for loop to add numbers to ArrayList
		ArrayList<Integer> mixedNumbs = new ArrayList<>();
		for(int i=0; i<100;i++) {
			mixedNumbs.add(i+1);
		}
		
		System.out.println("Prime Numbers between 1 and 100: ");
		
		//for-each loop that prints an int from the list if isPrime returns true
		for(int i : mixedNumbs) {
			if(isPrime(i)) {
				System.out.print(i+" ");
			}
		}
	}
	
	
	/*
	 * Function to check if an integer is prime. Takes an int as input and 
	 * returns a boolean
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
