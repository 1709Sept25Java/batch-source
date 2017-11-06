package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.CalculatorService;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		CalculatorService cs = (CalculatorService) ac.getBean("calculatorService");
		cs.calculate();
		System.out.println("done");
		((AbstractApplicationContext) ac).close();
	}

}
