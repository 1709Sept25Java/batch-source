package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.domain.Bat;
import com.revature.domain.Cave;

public class CaveDaoImpl implements CaveDao{
	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Cave> getCaves() {
		Session s = sessionFactory.getCurrentSession();
		List<Cave> caves = s.createQuery("from Cave").list();
		
		for(Cave c : caves) {
			System.out.println(c);
		}
		
		s.close();
		return caves;
	}

	@Override
	public Cave getCaveById(int id) {
		Session s = sessionFactory.getCurrentSession();
		Cave c = (Cave) s.get(Cave.class, id);
		s.close();
		return c;
	}

	@Override
	public int addCave(Cave c) {
		Session s = sessionFactory.getCurrentSession();
		int result = (int) s.save(c);
		s.close();
		System.out.println("TX complete");
		return result;
	}

	@Override
	public void updateCave(Cave c) {
		Session s = sessionFactory.getCurrentSession();
			s.merge(c);
		s.close();
		
	}

	@Override
	public void deleteCave(Cave c) {
		// TODO Auto-generated method stub
		
	}

}
