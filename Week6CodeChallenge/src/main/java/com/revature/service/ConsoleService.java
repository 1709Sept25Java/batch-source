package com.revature.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component(value="consoleService")
public class ConsoleService {
	
	public String datatypeInput() {
        Scanner sc = new Scanner(System.in);
        /*
         * Read user input
         * datatype entered should be of primitive types: int, double, float, etc
         * we make sure that switch cases will correspond by using to lowerCase method
         */
        System.out.println("What datatype would you like to use?");
        String datatype = sc.next();
        datatype = datatype.toLowerCase(); 
        //sc.close();
        return datatype;
	}
	
	public Number numberInput(String datatype, String order) {
		Scanner sc = new Scanner(System.in);
        /*
         * Read user input
         * datatype entered should be of primitive types: int, double, float, etc
         * we make sure that switch cases will correspond by using to lowerCase method
         */

        System.out.println("Enter "+order+" number to addded: ");
        String n1Input = sc.next();
        
       // sc.close();

        Number n1 = 0;
        switch(datatype) {
        	case "int":
        		n1 = Integer.parseInt(n1Input);
        		break;
        	case "double":
        		n1 = Double.parseDouble(n1Input);
        		break;
        	case "float":
        		n1 = Float.parseFloat(n1Input);
        		break;
        	case "byte":
        		n1 = Byte.parseByte(n1Input);
        		break;
        	case "short":
         		n1 = Short.parseShort(n1Input);
        		break;
        	case "long":
        		n1 = Long.parseLong(n1Input);
        		break;
        	default:
        		n1 =  -1000000000;
        }
        return n1;
	}
	
	
}
