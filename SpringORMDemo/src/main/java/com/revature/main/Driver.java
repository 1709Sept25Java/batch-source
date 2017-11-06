package com.revature.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.CaveDao;
import com.revature.domain.Cave;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext();
		CaveDao cd = (CaveDao) ac.getBean("caveDao");
		
		List<Cave> caves = cd.getCaves();
		System.out.println(caves);
		
		Cave c = (Cave) ac.getBean("cave");
		c.setMaxBears(5);
		c.setName("Jersey");
		cd.addCave(c);
	}
	
}
