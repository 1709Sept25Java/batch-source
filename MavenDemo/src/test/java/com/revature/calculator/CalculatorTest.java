package com.revature.calculator;

import static org.junit.Assert.*; // 

import org.junit.Test;

public class CalculatorTest {
	
	@Test(expected = RuntimeException.class) // this is useful because 
	public final void moreThanTwoThrowsException() { //tend to be final 
		Calculator.add("1,2,3"); //can do com.revature.calculator 
		
	}

	@Test
	public final void twoNumbersReturnsSum() {
		int sum = Calculator.add("23,79");
		assertEquals(102, sum);
	}

	@Test 
	public final void empteyStringReturnsZero() {
		int sum = Calculator.add("");
		assertEquals(0,sum);
			}

}

// run as jUnit