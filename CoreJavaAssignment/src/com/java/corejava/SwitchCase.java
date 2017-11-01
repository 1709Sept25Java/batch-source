package com.java.corejava;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;


public class SwitchCase {

	public static void main(String[] args) {
		
		
		int pickCase = 3;
		
		switch (pickCase) {
		
		case 1: 
			double x = 9; 
			System.out.println("The square root of " + x + " is " + Math.sqrt(x));
			break;
		case 2: 
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate localDate = LocalDate.now();
			System.out.println(dtf.format(localDate));
			break; 
		case 3:
			
            String str = "I am learning Core Java";
         
            String strArray[] = str.split(" ");
           
            System.out.println("String converted to String array");
           
            for(int i=0; i < strArray.length; i++){
                    System.out.println(strArray[i]);}
			break;
		
		} 
		
	}

}


/*Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java 
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
          	“I am learning Core Java” */
