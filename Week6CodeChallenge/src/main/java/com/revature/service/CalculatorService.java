package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value="calculatorService")
public class CalculatorService {
	/*
	 * The add method takes in Number types 
	 */
	
	public Number add(Number n1, Number n2) {
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
