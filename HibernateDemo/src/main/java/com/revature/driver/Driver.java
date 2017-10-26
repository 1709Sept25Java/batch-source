package com.revature.driver;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		BatDao bd = new BatDaoImpl();
		CaveDao cd = new CaveDaoImpl();
		bd.getBats();
		
		//save
		//cd.addCave(new Cave("awesomecave2",3));
		
		//update
		Cave c = new Cave(4,"newnameforawesomecave2",3);
		cd.updateCave(c);
	}
	
	static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		//If you run for Bears you get the bear and all the affiliated objects
		List<BearType> bearTypes = s.createQuery("from BearType").list();
		
		for(BearType b : bearTypes) {
			System.out.println(b);
		}
		
		Cave c1 = new Cave("Prague",5);
		Cave c2 = new Cave("Madrid",20);
		
		/*
		Bat b1 = new Bat("Susan",c1);
		Bat b2 = new Bat("Bob",c1);
		Bat b3 = new Bat("Hans",c1);
		Bat b4 = new Bat("Barney",c2);
		Bat b5 = new Bat("NosFeratu",c2);
		*/
		
		System.out.println(s.save(c1));
		System.out.println(s.save(c2));
		
		/*
		System.out.println(s.save(b1));
		System.out.println(s.save(b2));
		System.out.println(s.save(b3));
		System.out.println(s.save(b4));
		System.out.println(s.save(b5));
		*/
		
		tx.commit();
		s.close();
	}
}
