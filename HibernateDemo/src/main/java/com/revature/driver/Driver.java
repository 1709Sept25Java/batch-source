package com.revature.driver;

import java.util.List;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.*;
import com.revature.util.HibernateUtil;

import com.revature.dao.*;

public class Driver {

	public static void main(String[] args) {
		//init();
		BatDao bd = new BatDaoImpl();
		CaveDao cd = new CaveDaoImpl();
		//System.out.println(bd.getBats());
		
		//get v load
		/*
		if (bd.getBatById(2) != null) {
			System.out.println("bat 2 exists");
		} else {
			System.out.println("bat 2 does not exist");
		}
		System.out.println(bd.getBatById(2));
		*/
		
		//save
		//System.out.println(cd.addCave(new Cave("awesomecave2",3)));
		
		//update
		//Cave c = new Cave(92,"newnameforawesomecave2",3);
		//cd.updateCave(c);
		
		updateAndMerge();
	}
	
	static void updateAndMerge(){
		Cave c = new Cave("testCave",2);
	    Session s1 = HibernateUtil.getSession();
        Transaction tx1 = s1.beginTransaction();
        int genId = (Integer) s1.save(c);
        tx1.commit();
        s1.close();

        c.setMaxBears(3);

        Session s2 = HibernateUtil.getSession();
        Transaction tx2 = s2.beginTransaction();
        try {
        	Cave updatedCave=(Cave)s2.get(Cave.class,genId);//now same object with persistent state attached to s2.
            c.setMaxBears(9);
        	//s2.update(c);//will throw exception because update will try to reattach cave object to s2 and 
            //already one persistent object with same identifier

            s2.merge(c);//it will execute fine.

            tx2.commit();
        } catch (NonUniqueObjectException ex) {
            ex.printStackTrace();
        }
        s2.close();
	}

	static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
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
		System.out.println("finished tx");
		s.close();
	}

}
