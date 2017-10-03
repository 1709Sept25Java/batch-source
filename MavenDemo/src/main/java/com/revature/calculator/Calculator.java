package com.revature.calculator;

public class Calculator {

	/*
	 * Requirement 1: Create a string calculator with a method int add(String numbers)
	 * The method can take 0, 1 or 2 numbers, delimited by a comma ,
	 * Requirements 2: the method will return csum
	 * Requirement 3: empty string return zero
	 */
	public static int add(String numbers) {
		int sum = 0; //Must initialize because it's a local variable therefore no default value
		if (numbers.equals("")) {
			return sum;
		}
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 2) {
			throw new RuntimeException("Too many numbers"); //Could throw a custom checked exception
		}
		else {
			for (String number: numbersArray) {
				if (!numbers.equals("")) {
					sum += Integer.parseInt(number);
				}
				else {
					continue; //allow for consecutive commas
				}
			}
		}
		return sum; 
	}
}
