package com.revature.beans;

import org.springframework.stereotype.Component;

@Component(value="floatCalcultor")
public class FloatCalculator implements GenericCalculator{

	@Override
	public Float add(Number a, Number b) {
		Float result = a.floatValue() + b.floatValue();
		
		return result;
	}

	@Override
	public Float subtract(Number a, Number b) {
		Float result = a.floatValue() - b.floatValue();
		
		return result;
	}

	@Override
	public Float multiply(Number a, Number b) {
		Float result = a.floatValue() * b.floatValue();
		
		return result;
	}

	@Override
	public Float divide(Number a, Number b) {
		Float result = a.floatValue() / b.floatValue();
		
		return result;
	}
	
	public Float calc(Number a, Number b, String op) {
		
		Float result = (float) 0;
		
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
