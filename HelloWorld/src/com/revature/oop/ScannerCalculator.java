package com.revature.oop;

import java.util.Scanner;

public class ScannerCalculator {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Scanner calculator!");
		System.out.println("Please enter the datatype you would like to add: ");
		System.out.println("(Valid Inputs: byte,short,int,long,float,double)");
		
		reader();
		
	}
	
	
	public static void reader() {
		
		//Read the type to be added
		Scanner sc= new Scanner(System.in);
		String type=sc.nextLine();
		
		System.out.println("Please enter two numbers with a space in between: ");
		//Read the numbers
		String str=sc.nextLine();
		String[] toAdd=str.split(" ");
		
		sc.close();
		
		Number result; //Generic number to hold result
		
		//Check the data type and run the corresponding case
		switch(type) {
		case "short":
			Short s1= Short.parseShort(toAdd[0]); //convert string to short
			Short s2= Short.parseShort(toAdd[1]);
			result = add(s1,s2).shortValue(); //Send to the adder and cast in correct type
			break;
		case "int":
			Integer i1= Integer.parseInt(toAdd[0]); //convert string to int
			Integer i2= Integer.parseInt(toAdd[1]);
			result = add(i1,i2).intValue(); //Send to the adder and cast in correct type
			break;
		case "long":
			Long l1= Long.parseLong(toAdd[0]); //convert string to long
			Long l2= Long.parseLong(toAdd[1]);
			result = add(l1,l2).longValue(); //Send to the adder and cast in correct type
			break;
		case "float":
			Float f1= Float.parseFloat(toAdd[0]); //convert string to float
			Float f2= Float.parseFloat(toAdd[1]);
			result = add(f1,f2).floatValue(); //Send to the adder and cast in correct type
			break;
		case "double":
			Double d1= Double.parseDouble(toAdd[0]); //convert string to double
			Double d2= Double.parseDouble(toAdd[1]);
			result = add(d1,d2).doubleValue(); //Send to the adder and cast in correct type
			break;
		case "byte":
			Byte b1= Byte.parseByte(toAdd[0]); //convert string to byte
			Byte b2= Byte.parseByte(toAdd[1]);
			result = add(b1,b2).byteValue(); //Send to the adder and cast in correct type
		default:
			System.out.println("Indvalid datatype!"); //Default for invalid data type 
			result = -1;
		}
		
		System.out.println(result); //output result to console
		
	}
	
	
	
	public static Number add(Number n1, Number n2) {
		
		//The mildly cheat way to make the numbers add without switching (better option)
		Double result= n1.doubleValue()+ n2.doubleValue();
		
		return result;
	}
	
}
