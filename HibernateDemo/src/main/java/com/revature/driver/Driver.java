package com.revature.driver;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
		
		//updateAndMerge();
		
		//cascades
		//Cave c3 = cd.getCaveById(25);
		/*Bat newBat = new Bat("George",c3);
		bd.addBat(newBat); */
		
		//cd.deleteCave(c3);
		/*Cave c4 = new Cave("Queens",7);
		Bat newBat2 = new Bat("Ernie",c4);
		bd.addBat(newBat2);*/
		
		//moreBears();
		//Cave c1 = cd.getCaveById(27);
		//executeNamedQuery(c1);
		
		//funWithCriteria();
		
		//funWithCache();
		
		//newAnimals();
		
		//init();
		moreBears();
	}
	
	static void updateAndMerge(){
		
		Cave c = new Cave("testCave2",2); //transient
		
	    Session s1 = HibernateUtil.getSession();
        Transaction tx1 = s1.beginTransaction();
        int genId = (Integer) s1.save(c);
        tx1.commit();
        s1.close();

       //c is in the detached state 

        Session s2 = HibernateUtil.getSession();
        Transaction tx2 = s2.beginTransaction();
        try {
        	
        	Cave c2 =(Cave)s2.get(Cave.class,genId);//now same object with persistent state attached to s2.
        	//c2 is in the persistent state
        	c.setMaxBears(9);
        	//c is still detached
        	
        	//s2.update(c);
        	//will throw exception because update will try to reattach cave object to s2 and 
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
	
	static void moreBears(){
		
		CaveDao cd = new CaveDaoImpl();
		Cave c1 = cd.getCaveById(1);
		Cave c27 = cd.getCaveById(27);
		BearType bt = new BearType(6,"Grizzly");
		
		Bear b1 = new Bear("Francis",c27,bt,500,new Date(2013,9,05));
		Bear b2 = new Bear("Stacy",c27,bt,400,new Date(2013,9,05));
		Bear b3 = new Bear("Jason",c27,bt,500,new Date(2013,9,05));
		Bear b4 = new Bear("Elrond",c27,bt,2000,new Date(500,9,05));
		
	//	Bear b5 = new Bear("Josephine",c1,bt,300,new Date(1980,8,3));
		BearDao bd = new BearDaoImpl();
		
		
		bd.addBear(b1);
		bd.addBear(b2);
		bd.addBear(b3);
		bd.addBear(b4);
		
	//	bd.addBear(b5);
		
	}
	
	static void executeNamedQuery(Cave c){
		Session s = HibernateUtil.getSession();
		Query q = s.getNamedQuery("findBearByCave");
		q.setInteger("caveVar",c.getId());
		List<Bear> bears = q.list();
		System.out.println(bears.size());
		Iterator<Bear> itr = bears.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		s.close();
	}
	
	static void funWithCriteria(){
		Session s = HibernateUtil.getSession();
		
		System.out.println("bears with j");
		List<Bear> bearsWithJs = s.createCriteria(Bear.class).add(Restrictions.like("name","J%")).list();
		for (Bear b : bearsWithJs){
			System.out.println(b);
		}
		
		System.out.println("medium bears");
		List<Bear> mediumBears = s.createCriteria(Bear.class).add(Restrictions.between("weight", 400, 1000))
				.addOrder(Order.asc("weight")).list();
		for (Bear b : mediumBears){
			System.out.println(b);
		}
		
		//use Projections to do aggregate functions
		
		Criteria cr = s.createCriteria(Bear.class);
		cr.setProjection(Projections.rowCount());
		List rowsToCount = cr.list();
		//System.out.println(rowsToCount);
		System.out.println("number of bears: "+rowsToCount.get(0));
		
		Criteria bearWeight = s.createCriteria(Bear.class);
		bearWeight.setProjection(Projections.sum("weight"));
		List totalBear = bearWeight.list();
		System.out.println("total weight of all bears: "+totalBear.get(0));
		
		s.close();
	}
	
	static void funWithCache() {
		Session s = HibernateUtil.getSession();
		
		Cave c = (Cave) s.load(Cave.class, 27);
		System.out.println(c.getName());
		
		s.evict(c); //we'll have to query the db again to retrieve the cave because we
					//removed c from the session cache 
		//s.clear(); also works, but for all cached info
		
		c = (Cave) s.load(Cave.class, 27);
		System.out.println(c.getName());
		
		s.close();
		
	}
	
	static void newAnimals(){
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Cave c = (Cave) s.get(Cave.class, 27);
		//Animal a = new Animal("mystery",c);
		Bat b = new Bat("notErnie",c);
		Bat b2 = new Bat("alsoNotErnie",c);
		//s.save(a);
		s.save(b);
		s.save(b2);
		tx.commit();
		s.close();
	}

}
