package com.revature.assignment1;

public class Question03 {
	public static void main(String[] args) {
		String str = "hello";
		System.out.println("Reverse string '" + str + "' to: " + reverseString(str));
		
	}
	
	public static String reverseString (String str) {
		//Convert string to character array which allows us to modify elements
		char[] array = str.toCharArray();
		
		//Get the index of the last element in the string
		int index = array.length-1;
		
		//Copy the elements from string into character array in reverse order 
		for (int i=0; i<array.length; i++) { //Move through array left -> right
			array[i] = str.charAt(index); 
			index--;  //Move through string right -> left
		}
		return String.valueOf(array);
	}
}