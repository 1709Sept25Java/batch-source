package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory session;
	
	private static SessionFactory getSessionFact(String filename) {
		
		if(HibernateUtil.session != null) {
			return HibernateUtil.session;
		} else {
			Configuration con = new Configuration().configure(filename);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
			return con.buildSessionFactory(sr);
		}
		
	}
	
	public static Session getSession() {
		
		return getSessionFact("hibernate.cfg.xml").openSession();
	}
	
}
