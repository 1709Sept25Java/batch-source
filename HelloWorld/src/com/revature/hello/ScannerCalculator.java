package com.revature.hello;
import java.util.Scanner;

public class ScannerCalculator {

	public static void main(String[] args) {
		System.out.println("The sum of your two numbers is: " + userInput());
	}
	
	/*
	 * This class will read user input and call the add method
	 * It will also return the answer from the add method
	 */

	public static Number userInput() {
        Scanner sc = new Scanner(System.in);

        /*
         * Read user input
         * datatype entered should be of primitive types: int, double, float, etc
         * we make sure that switch cases will correspond by using to lowerCase method
         */
        System.out.println("What datatype would you like to use?");
        String datatype = sc.nextLine();
        datatype = datatype.toLowerCase(); 

        System.out.println("Enter first number to addded: ");
        String n1Input = sc.nextLine();
        
        System.out.println("Enter first number to addded: ");
        String n2Input = sc.nextLine();

        
        /*
         * Declare number types n1 & n2
         * switch cases work based on user input and parse based on that datatype
         * the default case is a random value -10000000 to signal an error
         */
        Number n1;
        Number n2;
        switch(datatype) {
        	case "int":
        		n1 = Integer.parseInt(n1Input);
        		n2 = Integer.parseInt(n2Input);
        		break;
        	case "double":
        		n1 = Double.parseDouble(n1Input);
        		n2 = Double.parseDouble(n2Input);
        		break;
        	case "float":
        		n1 = Float.parseFloat(n1Input);
        		n2 = Float.parseFloat(n2Input);
        		break;
        	case "byte":
        		n1 = Byte.parseByte(n1Input);
        		n2 = Byte.parseByte(n2Input);
        		break;
        	case "short":
         		n1 = Short.parseShort(n1Input);
        		n2 = Short.parseShort(n2Input); 
        		break;
        	case "long":
        		n1 = Long.parseLong(n1Input);
        		n2 = Long.parseLong(n2Input);
        		break;
        	default:
        		n1 =  -1000000000;
        		n2 =  -1000000000;
        }
        
        //We call the add method
        return add(n1, n2);
	}
	
	/*
	 * The add method takes in Number types 
	 */
	
	public static Number add(Number n1, Number n2) {
		String datatype = n1.getClass().getSimpleName();
		Number n; 
		switch(datatype) {
	    	case "Integer":
	    		n = n1.intValue() + n2.intValue(); 
	    		break;
	    	case "Double":
	    		n = n1.doubleValue() + n2.doubleValue(); 
	    		break;
	    	case "Float":
	    		n = n1.floatValue() + n2.floatValue();
	    		break;
	    	case "Byte":
	    		n = n1.byteValue() + n2.byteValue();
	    		break;
	    	case "Short":
	    		n = n1.shortValue() + n2.shortValue();
	    		break;
	    	case "Long": 
	    		n = n1.longValue() + n2.longValue();
	    		break;
	    	default:
	    		n =  -1000000000;
		}
		return n;
    		
	}
}
