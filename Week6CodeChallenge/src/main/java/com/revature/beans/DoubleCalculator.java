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

}
