package com.revature.beans;

import org.springframework.stereotype.Component;

@Component(value="doubleCalcultor")
public class DoubleCalculator implements GenericCalculator{

	@Override
	public Double add(Number a, Number b) {
		Double result = a.doubleValue() + b.doubleValue();
		
		return result;
	}

	@Override
	public Double subtract(Number a, Number b) {
		Double result = a.doubleValue() - b.doubleValue();
		
		return result;
	}

	@Override
	public Double multiply(Number a, Number b) {
		Double result = a.doubleValue() * b.doubleValue();
		
		return result;
	}

	@Override
	public Double divide(Number a, Number b) {
		Double result = a.doubleValue() / b.doubleValue();
		
		return result;
	}
	
public Double calc(Number a, Number b, String op) {
		
		Double result=0.0;
		
		switch(op) {
		case "+":
			result = add(a,b);
			break;
		case "-":
			result = subtract(a,b);
			break;
		case "*":
			result = multiply(a,b);
			break;
		case "/":
			result = divide(a,b);
			break;
		default:
			break;
		}
		
		return result;
	}

}
