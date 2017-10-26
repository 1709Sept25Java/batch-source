package com.revature.driver;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		//init();
	}

	static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		/*
		List<Bear> bears = s.createQuery("from Bear").list();

		for (Bear b : bears) {
			System.out.println(b);
		}*/
		
		//create transient objects
		
		Cave c1 = new Cave("Prague",5);
		Cave c2 = new Cave("Madrid",20);
		
		Bat b1 = new Bat("Susan",c1);
		Bat b2 = new Bat("Bob",c1);
		Bat b3 = new Bat("Hans",c1);
		Bat b4 = new Bat("Barney",c2);
		Bat b5 = new Bat("Nosferatu",c2);
		
		//persist them, and print out generated identifiers
		
		System.out.println(s.save(c1));
		System.out.println(s.save(c2));
		
		System.out.println(s.save(b1));
		System.out.println(s.save(b2));
		System.out.println(s.save(b3));
		System.out.println(s.save(b4));
		System.out.println(s.save(b5));
		
		tx.commit();
		s.close();
	}

}
