package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = Logger.getRootLogger();

	@AfterReturning(pointcut = "within(com.revature.service.*)", returning = "returnValue")
	public void logAfter(JoinPoint jp, Object returnValue) {
		 log.info(returnValue.toString());
	}
}
//Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'consoleService' defined in file [C:\Users\anahi\GitRepos\1709-sept25-java\batch-source\Week6CodeChallenge\target\classes\com\revature\service\ConsoleService.class]: Initialization of bean failed; nested exception is java.lang.IllegalArgumentException: warning no match for this type name: com.revature.service.ConsoleService.datatypeInput [Xlint:invalidAbsoluteTypeName]

