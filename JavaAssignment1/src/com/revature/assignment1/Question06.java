package com.revature.assignment1;

public class Question06 {

	public static void main(String[] args) {
		int number = 67;
		System.out.println("The number '" + number + "' is even? " + isEven(number));

	}
	
	public static Boolean isEven(int n) {
		//Divide the number by two 
			//Note: int datatype will truncate/round down
		int evenCheck = n/2;
		
		//If it's an even number than we should get back the initial value
			//when we multiply the value by 2
		if (evenCheck*2 == n) {
			return true;
		}
		return false;
	}
}
