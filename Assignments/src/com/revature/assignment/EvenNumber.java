package com.revature.assignment;
import java.util.Scanner;

public class EvenNumber {

	public static void main(String[] args) {
		
						 
		    int num;
		    Scanner input = new Scanner(System.in);
		 
		    System.out.println("Enter a number to check if it is even ");
		    num = input.nextInt();
		 
		    if((num / 2)*2 == num){
		        System.out.println(+num+" is Even number");
		    }else{
		        
		    	System.out.println(" sorry this number is not even ");
		    	
		    }
		 
		}
	

	}

