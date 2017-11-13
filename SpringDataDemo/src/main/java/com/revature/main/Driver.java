package com.revature.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.dao.BearDao;
import com.revature.dao.CaveDao;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		CaveDao cd = (CaveDao) ac.getBean("caveDao");

		/*List<Cave> caves = cd.findAll();
		System.out.println(caves);*/
		
		/*List<Bear> bears = ((BearDao) ac.getBean("bearDao")).findAll();
		System.out.println(bears);*/
		
		System.out.println(cd.findCaveByName("Jersey"));

	/*	Cave c = (Cave) ac.getBean("cave");
		c.setMaxBears(6);
		c.setName("Jersey2");
		cd.save(c);*/
		((AbstractApplicationContext) ac).close();
	}

}