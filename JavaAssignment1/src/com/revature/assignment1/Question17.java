package com.revature.assignment1;
import java.util.Scanner;

public class Question17 {

	public static void main(String[] args) {
		calculateSimpleInterest();
	}
	
	/*
	 * Calculates simple interest using interest = principal * rate * time
	 */
	public static void calculateSimpleInterest() {
		
		//Call user input function with variable needed
		Double principal = userInput("principal");
		Double rate = userInput("rate");
		Double time = userInput("time");

		//Calculate simple interest based on user input
        Double simpleInterest = principal * rate * time;
        
        //Print results
        System.out.println("Calculated simple interest: " + simpleInterest );
	}
	
	/*
	 * Requesting user input is the same for the three variables
	 * We only need to specify the variable we request 
	 * Type can be principal, rate or time
	 */
	public static Double userInput(String type) {
		Scanner sc = new Scanner(System.in);
		
		//We use type to request the variable to user
        System.out.println("Enter "+ type +": ");
        
        //Get user input in string format
        String input = sc.nextLine();
        
        //Parse string format into a double
        Double numericInput = Double.parseDouble(input);
        
        //Return the user input as a double
        return numericInput;
	}

}
