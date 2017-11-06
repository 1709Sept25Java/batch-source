package com.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

	private static Logger log= Logger.getRootLogger();
	
	@AfterReturning(pointcut="within(com.calculations.*)")
	public void logAfter(JoinPoint jp) {
	/*	log.info(jp.getSignature());*/
		
	}
	
	@AfterReturning(pointcut = "within(com.calculations.*)")
	public void logAfterThrow(JoinPoint jp) {
		log.warn(jp.getSignature());
	}
}
