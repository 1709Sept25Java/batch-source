package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Animal;
import com.revature.domain.Bat;
import com.revature.util.HibernateUtil;
import com.revature.domain.Bat;

public class BatDaoImpl implements BatDao{

	@Override
	public List<Bat> getBats() {
		Session s = HibernateUtil.getSession();
		List<Bat> bats = s.createQuery("from Bat").list();
		
		for(Bat b : bats) {
			System.out.println(b);
		}
		
		s.close();
		
		return bats;
	}

	@Override
	public Bat getBatById(int id) {
		Session s = HibernateUtil.getSession();
		Bat b = (Bat) s.get(Animal.class, id);
		s.close();
		return b;
	}

	@Override
	public int addBat(Bat b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		
		
		tx.commit();
		s.close();
		return 0;
	}

	@Override
	public void updateBat(Bat b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBat(Bat b) {
		// TODO Auto-generated method stub
		
	}

}
