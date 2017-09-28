package com.ravature.hello;

import java.util.Scanner;

public class ScannerCalculator {
	// I was only able to perfom different operator I did not get a chance to work on the switch datatypes
	// i did not know how to do it so i was going to try to do after the operator 
	 public static void main(String[] args) {
		 
		 Scanner Calc = new Scanner(System.in);
	        int n1;
	        int n2;
	        int Answer;

	        System.out.println("Enter the first number: ");
	        n1 = Calc.nextInt();
	        System.out.println("Enter the second number:" );
	        n2 = Calc.nextInt();
	        Calc.nextLine();
	        System.out.println("Select the order of operation: ");
	        char operate = Calc.nextLine().charAt(0);


	        if (operate == '+') {
	            Answer = (n1 + n2);
	            System.out.println("Answer:" + Answer);
	            } 
	        if (operate == '-') {
	            Answer = (n1 - n2);
	            System.out.println("Answer:" + Answer);
	            } 
	        if (operate == '*') {
	            Answer = (n1 * n2);
	            System.out.println("Answer:" + Answer);
	            } 
	        if (operate == '/') {
	            Answer = (n1/n2);
	            System.out.println("Answer:" + Answer);
	            } 
	        else {
	            System.out.println("not implemented yet. Sorry!");
	        }


	    }

	 }
	 
		 

