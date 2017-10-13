package junit.demo;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	//generally make test methods finals\
	@Test(expected = RuntimeException.class)
	public final void moreThanTwoThrowsException()
	{
		int sum=Calculator.add("1,2,3");
		assertEquals(102,sum);
	}
}
