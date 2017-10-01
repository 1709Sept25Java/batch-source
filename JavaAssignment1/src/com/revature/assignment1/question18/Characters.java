package com.revature.assignment1.question18;

//Characters Class extends CharacterCase Superclass  
	//and implements the abstract methods defined there
public class Characters extends CharacterCase {

	//Constructor
	public Characters() {
		super();
	}

	//Checks whether there are any uppercase characters in a string
		//Return false if all lowercase characters
		//Return true if there is any uppercase character
	@Override
	public Boolean uppercaseCheck(String input) {
		
		Character current; 
		
		//Iterate through string characters
		for (int i=0; i<input.length();i++) {
			
			current = input.charAt(i); //Current character we are looking at
			
			//If the character is uppercase then we return true
				//because we have found one uppercase character
			if (Character.isUpperCase(current)) {
				return true;
			}
		}
		
		//After iterating through string found no uppercase characters
		return false;
	}

	//Convert all lowercase characters to uppercase characters
	@Override
	public String lowerToUpperCase(String input) {
		
		Character current;
		
		//Declare a StringBuilder to hold the string we will create
		StringBuilder output = new StringBuilder();
		
		//Iterate through string characters
		for (int i=0; i<input.length();i++) {
			
			current = input.charAt(i); //Current character we are looking at
			
			//If the character is lowercase we should make it uppercase 
			if (Character.isLowerCase(current)) {
				
				//Convert character to uppercase
				current = Character.toUpperCase(current);
				
				//Append the character to our StringBuilder
				output.append(current);
			}
			//If the character is already uppercase add it to StringBuilder
			else {
				output.append(current);
			}
		}
		
		//Convert from StringBuilder to String
		return output.toString();

		//Note: Could have also used String method toUpperCase
		//return input.toUpperCase();
	}

	//Convert from String to number and add 10
	@Override
	public void toInteger(String input) {
		
		//Use Integer method parseInt to convert into an Integer
		Integer output = Integer.parseInt(input);
		
		//Add 10 to the input value
		output+=10;
		
		//Print value to console
		System.out.print("3. " + input + " + " + "10 = " +output);
	}
	
}
