package com.revature.daoTest;

import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;

import org.junit.*;

import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;

public class RepayTest {

	@Test
	public final void newRepaymentTest() {
		String filename = "receipt.png";
		RepaymentDao rd = new RepaymentDaoImpl();
		boolean success = rd.newRepayment(3, 20.00, "Work Purchase", filename,new Timestamp(System.currentTimeMillis()), 1);
		
		assertTrue(success);
	}
	
	@Test
	public final void writeImage() {
		RepaymentDao rd = new RepaymentDaoImpl();
		rd.getReceipt(3);
		
	}
}
