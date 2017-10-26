package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private static SessionFactory getSessionFactory(String filename) {
		if (HibernateUtil.sessionFactory != null) {
			return HibernateUtil.sessionFactory;
		} else {
			Configuration c = new Configuration().configure(filename);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			return c.buildSessionFactory(sr);
		}
	}

	public static Session getSession() {
		return getSessionFactory("hibernate.cfg.xml").openSession();
	}

}
