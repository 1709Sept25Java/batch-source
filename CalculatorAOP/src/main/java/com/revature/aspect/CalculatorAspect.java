package com.revature.aspect;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorAspect {
	
	private static Logger logA = Logger.getLogger("loggerA");
	private static Logger logB = Logger.getLogger("loggerB");
	
	@After("within(com.revature.service.*)")
	public void logRequest(JoinPoint jp) {
		logA.info(jp.getSignature());
	}

	@After("within(com.revature.service.*)")
	public void logResult(JoinPoint jp) {
		logB.info(jp.getTarget());
	}
	
}
