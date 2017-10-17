package com.revature.calculator;

public class Calculator {

	
	/*
	 * Requirement 1: create a String calculator with a method int add(String numbers)
	 * The method can take, 0,1, or 2 numbers, delimited by comma, 
	 * Requirement 2: the method will return their sum
	 * Requirement 3: empty string returns 0 
	 * 
	 */
	
	public static int add(String numbers) {
		int sum = 0;
		if (numbers.equals("")){
			return sum;
		}
		String[] numbersArray = numbers.split(","); //split is a method that allows us to...
		if(numbersArray.length > 2) {
			throw new RuntimeException("too many numbers"); //we can also throw custom checked exception!! 
		} else {
			for(String number : numbersArray)  {
				if(!number.equals("")) {
					sum += Integer.parseInt(numbers); 
				} else {
					continue; // allows for consecutive commas
				}
			}
				
		}
		
		return sum; //sum is a local variable so, no default value 
	}
}
