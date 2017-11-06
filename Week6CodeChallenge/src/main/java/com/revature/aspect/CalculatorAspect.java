package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorAspect {

	@AfterReturning(pointcut="execution(* add(..))")
	public void afterAdd(JoinPoint jp) {
		System.out.println("You have successfully added two numbers!");
	}
	
	@AfterReturning(pointcut="execution(* sub(..))")
	public void afterSub(JoinPoint jp) {
		System.out.println("You have successfully subtracted two numbers!");
	}
	
	@AfterReturning(pointcut="execution(* mult(..))")
	public void afterMult(JoinPoint jp) {
		System.out.println("You have successfully multiplied two numbers!");
	}
	
	@AfterReturning(pointcut="execution(* div(..))")
	public void afterDiv(JoinPoint jp) {
		System.out.println("You have successfully divided two numbers!");
	}
}
