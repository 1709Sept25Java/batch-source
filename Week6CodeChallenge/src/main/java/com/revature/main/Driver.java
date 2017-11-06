package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.revature.service.*;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Driver class");
		ConsoleService conService = (ConsoleService) ac.getBean("consoleService");
		String datatype = conService.datatypeInput();
		Number n1 = conService.numberInput(datatype, "first");
		Number n2 = conService.numberInput(datatype, "second");
		
		CalculatorService calcService = (CalculatorService) ac.getBean("calculatorService");
		System.out.println("Result: " + calcService.add(n1,n2));

		((AbstractApplicationContext) ac).close();
	}
}
