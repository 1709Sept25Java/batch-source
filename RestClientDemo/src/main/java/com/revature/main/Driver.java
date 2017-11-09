package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.client.BatClient;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("rootBeans.xml");
		BatClient bc = ac.getBean("batClient",BatClient.class);
		bc.setResourceUrl("http://localhost8082:/RestServiceDemo");
		
		((AbstractApplicationContext) ac).close();
	}
	
}
