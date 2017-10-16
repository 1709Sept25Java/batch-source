package com.java.corejava;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		
			
		      String input, reverse = ""; // variable to hold input sting and store reversed string
		      
		      Scanner in = new Scanner(System.in);
		      System.out.println("Enter a string to reverse");
		      input = in.nextLine();
		 
		  
		 
		      for ( int i = input.length()-1; i >= 0; i--) // iterates through the string backwards 
		         reverse = reverse + input.charAt(i);
		 
		      System.out.println("Reverse of entered string is: "+reverse);
		      
		   } 
		

}
