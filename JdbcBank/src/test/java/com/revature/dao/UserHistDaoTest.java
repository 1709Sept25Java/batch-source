package com.revature.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.revature.domain.UserHist;

public class UserHistDaoTest {

	//Test the view history function
	@Test
	public final void viewHistTest() {
		UserHistDao uhDao = new UserHistDaoImpl();
		List<UserHist> uh = uhDao.getHistory(1);
		
		assertTrue(uh.isEmpty());	
	}
	
}
