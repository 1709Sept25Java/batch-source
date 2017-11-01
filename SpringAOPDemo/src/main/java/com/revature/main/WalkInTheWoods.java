package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.BearService;
import com.revature.service.TigerService;

public class WalkInTheWoods {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		/*TigerService ts = (TigerService) ac.getBean("tigerService");
		ts.wakeUpAnimal();
		ts.animalChasesYou();
		ts.animalCatchesYou();*/
		
		BearService bs = (BearService) ac.getBean("bearService");
		bs.setIsWinter(false);
		try {
			bs.bearhibernates();
			bs.wakeUpAnimal();
			bs.animalChasesYou();
			bs.animalCatchesYou();
		}catch(Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ac).close();
	}

}
