package com.revature.beans;

import org.springframework.stereotype.Component;

@Component(value="byteCalcultor")
public class ByteCalculator implements GenericCalculator{

	@Override
	public Byte add(Number a, Number b) {
		Byte result = (byte) (a.byteValue() + b.byteValue());
		
		return result;
	}

	@Override
	public Byte subtract(Number a, Number b) {
		Byte result = (byte) (a.byteValue() - b.byteValue());
		
		return result;
	}

	@Override
	public Byte multiply(Number a, Number b) {
		Byte result = (byte) (a.byteValue() * b.byteValue());
		
		return result;
	}

	@Override
	public Byte divide(Number a, Number b) {
		Byte result = (byte) (a.byteValue() / b.byteValue());
		
		return result;
	}

}
