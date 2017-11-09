package com.revature.beans;

import org.springframework.stereotype.Component;

@Component(value="shortCalcultor")
public class ShortCalculator implements GenericCalculator{

	@Override
	public Short add(Number a, Number b) {
		Short result = (short) (a.shortValue() + b.shortValue());
		
		return result;
	}

	@Override
	public Short subtract(Number a, Number b) {
		Short result = (short) (a.shortValue() - b.shortValue());
		
		return result;
	}

	@Override
	public Short multiply(Number a, Number b) {
		Short result = (short) (a.shortValue() * b.shortValue());
		
		return result;
	}

	@Override
	public Short divide(Number a, Number b) {
		Short result = (short) (a.shortValue() / b.shortValue());
		
		return result;
	}
	
	public Short calc(Number a, Number b, String op) {
		
		Short result=0;
		
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
