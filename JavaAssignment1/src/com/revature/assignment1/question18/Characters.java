package com.revature.assignment1.question18;

public class Characters extends CharacterCase {

	public Characters() {
		super();
	}

	@Override
	public Boolean uppercaseCheck(String input) {
		Character current;
		for (int i=0; i<input.length();i++) {
			current = input.charAt(i);
			if (Character.isUpperCase(current)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String lowerToUpperCase(String input) {
		Character current;
		
		StringBuilder output = new StringBuilder();
		
		String outputString;
		
		for (int i=0; i<input.length();i++) {
			current = input.charAt(i);
			if (Character.isLowerCase(current)) {
				current = Character.toUpperCase(current);
				output.append(current);
			}
			else {
				output.append(current);
			}
		}
		outputString = output.toString();
		return outputString;
	}

	@Override
	public void toInteger(String input) {
		Integer output = Integer.parseInt(input);
		output+=10;
		System.out.println(output);
	}
	
}
