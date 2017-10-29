package com.driver;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.dao.*;
import com.domain.Flashcard;
import com.domain.Student;
import com.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		/*Session s = HibernateUtil.getSession();
		System.out.println(s.getStatistics());
		s.close();*/
		FlashcardDao fd = new FlashcardDaoImpl();
		StudentDao sd = new StudentDaoImpl();
		
	}
	static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx =s.beginTransaction();
		
		//create transient objects 
		Student s1 = new Student("Mulan","Hua");
		Student s2 = new Student("Shang","Li");
		
		Flashcard f1 = new Flashcard("abc","def",s1);
		Flashcard f2 = new Flashcard("hij","klm",s2);
		
		//persist objects and print generated identifiers
		System.out.println(s.save(s1));
		System.out.println(s.save(s2));
		
		System.out.println(s.save(f1));
		System.out.println(s.save(f2));
		
		tx.commit();
		System.out.println("finished tx-ing");
		s.close();
		
	}
	static void retrieveFirstThree(int id) {
		Session s = HibernateUtil.getSession();
		//Query query=s.createQuery("from Flashcard where id<4");
		List<Flashcard> flashlist= s.createCriteria(Flashcard.class).add(Restrictions.lt("id",new Integer(4))).list();
		for(Flashcard f: flashlist) {
			System.out.println(f);
		}
		s.close();
	}
	static void withCriteria() {
		Session s1 = HibernateUtil.getSession();
		List<Student> studentWithMs= s1.createCriteria(Student.class)
		.add(Restrictions.like("lastname","M%")).addOrder(Order.desc("lastname")).list();
		for(Student s : studentWithMs) {
			System.out.println(s);
		}
		s1.close();
	}
}
