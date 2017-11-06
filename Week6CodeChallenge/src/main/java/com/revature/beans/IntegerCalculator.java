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

}
