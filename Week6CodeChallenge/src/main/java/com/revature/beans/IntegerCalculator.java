package com.revature.beans;

import org.springframework.stereotype.Component;

@Component(value="integerCalcultor")
public class IntegerCalculator implements GenericCalculator{

	@Override
	public Integer add(Number a, Number b) {
		
		Integer result = a.intValue() + b.intValue();
		
		return result;
	}

	@Override
	public Integer subtract(Number a, Number b) {
		Integer result = a.intValue() - b.intValue();
		
		return result;
	}

	@Override
	public Integer multiply(Number a, Number b) {
		Integer result = a.intValue() * b.intValue();
		
		return result;
	}

	@Override
	public Integer divide(Number a, Number b) {
		Integer result = a.intValue() / b.intValue();
		
		return result;
	}

	@Override
	public Integer calc(Number a, Number b, String op) {
		
		Integer result=0;
		
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
