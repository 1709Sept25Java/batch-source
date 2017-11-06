package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut="within(com.revature.beans.*)", returning="returnVal")
	public void logUserRequests(JoinPoint jp) {
		log.info(jp.getSignature());
		
	}

}
