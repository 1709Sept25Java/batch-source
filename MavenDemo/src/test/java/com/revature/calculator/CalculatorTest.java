package com.revature.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test(expected = RuntimeException.class)
	//generally make test methods final
	
	public final void moreThanTwoThrowsException() {
		//com.revature.calculator.Calculator.add		//this can work too
		Calculator.add("1,2,3");
	}
	@Test
	public final void twoNumbersReturnSum() {
		int sum = Calculator.add("23,79");
		assertEquals(102,sum);
	}
	@Test
	public final void emptyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0,sum);
	}
}
