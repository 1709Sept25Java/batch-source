package com.revature.dao;

import java.util.List;

import org.hibernate.Session;

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
		Bat b = (Bat) s.get(Bat.class, id); //what if this was load()?????
		s.close();
		return b;
	}

	@Override
	public int addBat(Bat b) {
		// TODO Auto-generated method stub
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