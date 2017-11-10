package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Animal;
import com.revature.domain.Bat;
import com.revature.util.HibernateUtil;

public class BatDaoImpl implements BatDao {

	@Override
	public List<Bat> getBats() {
		Session s = HibernateUtil.getSession();
		List<Bat> bats = s.createQuery("from Bat").list();
			for(Bat b : bats){
				System.out.println(b);
			}
		s.close();
		return bats;
	}

	@Override
	public Bat getBatById(int id) {
		Session s = HibernateUtil.getSession();
		Bat b = (Bat) s.get(Animal.class, id); //what if this was load()?????
		s.close();
		return b;
	}

	@Override
	public int addBat(Bat b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = 0;//(int) s.save(b);
		s.saveOrUpdate(b);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void updateBat(Bat b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			s.merge(b);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteBat(Bat b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			s.delete(b);
		tx.commit();
		s.close();
	}

}
