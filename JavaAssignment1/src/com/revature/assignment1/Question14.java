package com.revature.assignment1;

import static java.lang.Math.sqrt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Question14 {
	public static void main(String[] args) {
		int option = 1;
		switchCases(option);
		
		option = 2;
		switchCases(option);
		
		option=3;
		switchCases(option);
	}
	
	public static void switchCases(int option) {
		
		//Switch on the variable option
		switch(option) {
		
			//Import Math package and print square root of the chose value 25
			case 1: 
				int x = 25;
				System.out.println("Case 1 \nThe square root of " + x + " is " + sqrt(x));
				break;
		
			//Create a SimpleDateFormat object with the chosen form of month/day/year
				//Create Date object and print the date with the date format 
			case 2:
				DateFormat df = new SimpleDateFormat("MM/dd/yy");
			    Date dateobj = new Date();
			    System.out.println("\nCase 2 \nToday's date is " + df.format(dateobj));
			    break;
	
			//Create a String array and parse the string with a space delimiter
			    //Print each word to the console
			case 3:
				String str = "I am learning Core Java";		
				
				//Array of words of the number of words in string
				String[] words = new String[5];
				
				System.out.println("\nCase 3");
				
				//Keep track of index in String array
				int index = 0;
				
				//Iterate through string delimiting at space (" ")
				for(String w:str.split(" ")){ //Iterating through string
					words[index] = w; //Store word in word array
					index++; //Iterating through word array
				}
				
				//Print words in word array
				System.out.println("There are " + words.length + " words in the string '" + str + "'");
				for(String w:words){
					System.out.println(w);
				}
				break;				
		}
	}
}
