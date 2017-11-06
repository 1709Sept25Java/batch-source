package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.revature.domain.Animal;
import com.revature.domain.Bat;

@Transactional
@Component(value="batDao")
@Scope(value="prototype")
public class BatDaoImpl implements BatDao{
	
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Bat> getBats() {
		Session s = sessionFactory.getCurrentSession();
		List<Bat> bats = s.createQuery("from Bat").list();
		
		for(Bat b : bats) {
			System.out.println(b);
		}
		
		s.close();
		
		return bats;
	}

	@Override
	public Bat getBatById(int id) {
		Session s = sessionFactory.getCurrentSession();
		Bat b = (Bat) s.get(Animal.class, id);
		s.close();
		return b;
	}

	@Override
	public int addBat(Bat b) {
		Session s = sessionFactory.getCurrentSession();
		
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
