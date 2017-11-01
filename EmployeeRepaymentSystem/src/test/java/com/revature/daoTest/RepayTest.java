package com.revature.daoTest;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Timestamp;

import org.junit.*;

import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;

public class RepayTest {

	@Test
	public final void newRepaymentTest() {
		String filename = "C:\\Users\\rebec\\tmp\\receipt.jpg";
		RepaymentDao rd = new RepaymentDaoImpl();
		FileInputStream in;
		try {
			
			in = new FileInputStream(filename);
			boolean success = rd.newRepayment(43, 20.00, "Work Purchase", in,new Timestamp(System.currentTimeMillis()), 1);
			assertTrue(success);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	@Test
	public final void writeImage() {
		RepaymentDao rd = new RepaymentDaoImpl();
		rd.getReceipt(3);
		
	}
	*/
}
