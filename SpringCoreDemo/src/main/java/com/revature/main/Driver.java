package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;

public class Driver {
	public static void main(String[] args){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		/*
		Bear b1 = (BearWithSetter) ac.getBean("bearWithSetter");
		b1.methodInBear();
		//Same cave different bear
		Bear b2 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b2.methodInBear();
		
		Bear b3 = (BearWithAutoWiringByType) ac.getBean("bearWithAutoWiringByType");
		b3.methodInBear();
		Bear b4 = (BearWithAutoWiringByName) ac.getBean("bearWithAutoWiringByName");
		b4.methodInBear();
		*/
		
		Bear b5 = (BearWithAutomagic) ac.getBean("bearWithAutomagic");
		b5.methodInBear();
		Cave c1 = b5.getCave();
		System.out.println(b5);
		System.out.println(c1);
		
		((AbstractApplicationContext) ac).close();
		b5.methodInBear();
	}
}
