package com.revature.driver;

import org.hibernate.Session;

import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		System.out.println(s.getStatistics());
	}

}
