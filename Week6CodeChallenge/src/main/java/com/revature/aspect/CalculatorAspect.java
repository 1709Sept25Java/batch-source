package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.revature.service.*;

@Aspect
@Component
public class CalculatorAspect {
	
	public void getNumber1() {
	}
	
	@Before(value = "")
	public void beforeChooseOp() {
		CalculatorService cs= new CalculatorService();
		cs.getNumber1();
		cs.getNumber2();
	}
	
	@After(value = "")
	public void afterChooseOp() { 
		
	}

}
