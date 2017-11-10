package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.revature.service.AnimalService;
import com.revature.service.PersonService;
import com.revature.service.TigerService;

@Aspect
@Component
public class AnimalAspect {
	
	@AfterReturning(pointcut="execution(* wake*(..))")
	public void afterWakeAnimal(JoinPoint jp){
		System.out.println("That was not a good choice.");
		//System.out.println(((AnimalService)jp.getTarget()).getSpeed());
		//System.out.println(((AnimalService)jp.getThis()).getSpeed());
	}

	//can it actually catch you?
	@Around("execution(* *CatchesYou(..))")
	public void afterCatchesYou(ProceedingJoinPoint pjp) throws Throwable {
		int personSpeed = PersonService.getSpeed();
		AnimalService as = (AnimalService) pjp.getTarget();
		if(personSpeed <= as.getSpeed()){
			System.out.println("You're too slow.");
			pjp.proceed();
			if (!as.getFull()){
				as.setFull(true);
				System.out.println("You became lunch.");
			} else {
				System.out.println("Bear/Tiger hug, no noms.");
			}
		}
		else {
			System.out.println("You got away!");
		}
	}
}
