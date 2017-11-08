package com.revature.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bat;
import com.revature.client.BatClient;

public class Driver {
	
	public static void main(String[] args){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("rootBeans.xml");
		BatClient bc = ac.getBean("batClient",BatClient.class);
		bc.setResourceUrl("http://localhost:8082/RestServiceDemo");
		
		//System.out.println(bc.getBats());
		
		Bat b = (Bat) ac.getBean("bat");
		b.setName("Ferdinand");
		
		System.out.println(bc.saveBat(b));
		
		
	}

}
