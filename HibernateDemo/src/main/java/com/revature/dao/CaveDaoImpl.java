package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Bat;
import com.revature.domain.Cave;
import com.revature.util.HibernateUtil;

public class CaveDaoImpl implements CaveDao {

	@Override
	public List<Cave> getCaves() {
		Session s = HibernateUtil.getSession();
		List<Cave> caves = s.createQuery("from Cave").list();
		for(Cave c : caves){
			System.out.println(c);
		}
		s.close();
		return caves;
	}

	@Override
	public Cave getCaveById(int id) {
		Session s = HibernateUtil.getSession();
		Cave c = (Cave) s.get(Cave.class, id); //what if this was load()?????
		s.close();
		return c;
	}

	@Override
	public int addCave(Cave c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = 0;//(int) s.save(c); //persist - no return type, guaranteed to execute in tx
		s.saveOrUpdate(c);
		tx.commit();
		s.close();
		return result;
	}

	@Override
	public void updateCave(Cave c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			//s.save(c);
			//s.update(c);
			//s.saveOrUpdate(c);
			s.merge(c);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteCave(Cave c) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			s.delete(c);
		tx.commit();
		s.close();
	}

}
