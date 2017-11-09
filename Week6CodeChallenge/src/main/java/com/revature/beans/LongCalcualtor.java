package com.revature.beans;

import org.springframework.stereotype.Component;

@Component(value="longCalcultor")
public class LongCalcualtor implements GenericCalculator{

	@Override
	public Long add(Number a, Number b) {
		Long result = a.longValue() + b.longValue();
		
		return result;
	}

	@Override
	public Long subtract(Number a, Number b) {
		Long result = a.longValue() - b.longValue();
		
		return result;
	}

	@Override
	public Long multiply(Number a, Number b) {
		Long result = a.longValue() * b.longValue();
		
		return result;
	}

	@Override
	public Long divide(Number a, Number b) {
		Long result = a.longValue() / b.longValue();
		
		return result;
	}
	
	public Long calc(Number a, Number b, String op) {
		
		Long result=(long) 0;
		
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
