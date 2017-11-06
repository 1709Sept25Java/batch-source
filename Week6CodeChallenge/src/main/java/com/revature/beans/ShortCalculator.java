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

}
