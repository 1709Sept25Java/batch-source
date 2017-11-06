package com.revature.aspect;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component 
public class LoggingAspect {

	private static Logger log = Logger.getRootLogger();
	
	@Pointcut("execution(* *.*(..))")
	protected void loggingOp() {}
	
	@Before("loggingOp()")
	public void logJoinPoint(JoinPoint jp) {
		log.info("Arguments :" + Arrays.toString(jp.getArgs()));
	}
	
	@AfterReturning(pointcut = "within(com.revature.service.*)", returning = "an")
	public void logAfterReturn(JoinPoint jp, Object an) {
		log.info("Method:" + jp.getSignature().getName());
		log.info("Return value: "+ an);
	}
	
	@AfterThrowing(pointcut = "within(com.revature.service.*)")
	public void logAfterThrow(JoinPoint jp) {
		log.error(jp.getSignature());
	}
}
