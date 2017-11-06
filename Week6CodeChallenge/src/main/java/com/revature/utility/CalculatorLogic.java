package com.revature.utility;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "calculatorLogic")
@Scope(value = "prototype")
public class CalculatorLogic {

	public void calculate() {

		CalculatorService calc = new CalculatorService();

	}
}
