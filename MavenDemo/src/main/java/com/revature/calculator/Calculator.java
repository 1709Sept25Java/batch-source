package com.revature.calculator;

public class Calculator {

	/*
	 * requirement 1: create a string calculator with a method int add (STring numbers)
	 * the method can take 0,1, or 2 numbers, delimited by a comma ","
	 * Requirement 2: the method will return their sum
	 * requirement 3: empty string returns 0
	 */
	
	public static int add(String numbers) {
		int sum = 0; //int sum; is a local variable with no default value
		if(numbers.equals("")) {
			return sum;
		}
		String[] numbersArray = numbers.split(",");
		if(numbersArray.length > 2) {
			throw new RuntimeException("Too many numbers"); // could also throw custom checked exception
		}else {
			//fill this in after we write our first unit test
			for(String number : numbersArray) {
				if(!number.equals("")) {
					sum+=Integer.parseInt(number);
				}else {
					continue; // allow for consecutive commas
				}
			}
		}
		
		return sum;
	}
}
