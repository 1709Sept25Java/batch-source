package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;

public class Driver {
	public static void main(String[] args){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Bear b1 = (BearWithSetter) ac.getBean("bearWithSetter");
		b1.methodInBear();
		
		((AbstractApplicationContext) ac).close();
	}
}
