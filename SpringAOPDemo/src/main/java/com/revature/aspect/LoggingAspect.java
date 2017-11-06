package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = Logger.getRootLogger();
	
	@AfterThrowing(pointcut="within(com.revature.service.*)")
	public void logAfterThrow(JoinPoint jp) {
		log.error(jp.getSignature());
	}
	
	/*
	@AfterReturning(pointcut="within(com.revature.service.*)")
	public void logAfter(JointPoint jp) {
		log.info(jp.getThis().getSignature());
	}
	*/
}
