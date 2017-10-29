package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.Bear;
import com.revature.util.HibernateUtil;

public class BearDaoImpl implements BearDao {

		public List<Bear> getBears() {
			Session s = HibernateUtil.getSession();
			List<Bear> Bears = s.createQuery("from Bear").list();
				for(Bear b : Bears){
					System.out.println(b);
				}
			s.close();
			return Bears;
		}

		public Bear getBearById(int id) {
			Session s = HibernateUtil.getSession();
			Bear b = (Bear) s.get(Bear.class, id); //what if this was load()?????
			s.close();
			return b;
		}

		public int addBear(Bear b) {
			Session s = HibernateUtil.getSession();
			Transaction tx = s.beginTransaction();
			int result = (Integer) s.save(b);
			tx.commit();
			s.close();
			return result;
		}

		public void updateBear(Bear b) {
			Session s = HibernateUtil.getSession();
			Transaction tx = s.beginTransaction();
				s.merge(b);
			tx.commit();
			s.close();
		}

		public void deleteBear(Bear b) {
			Session s = HibernateUtil.getSession();
			Transaction tx = s.beginTransaction();
				s.delete(b);
			tx.commit();
			s.close();
		}

	
}