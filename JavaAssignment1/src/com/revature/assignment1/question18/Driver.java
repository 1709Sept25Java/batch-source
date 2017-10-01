package com.revature.assignment1.question18;

public class Driver {

	public static void main(String[] args) {

		Characters input = new Characters();
		String input1 = "HELLo";
		String input2 = "15";
		System.out.println("1. The string '" + input1 +"' contains uppercase characters? " + input.uppercaseCheck(input1));
		System.out.println("2. The string '" + input1 + "' in all uppercase characters is '" + input.lowerToUpperCase(input1) + "'");
		input.toInteger(input2);
	}

}
