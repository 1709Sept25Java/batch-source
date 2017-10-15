package com.revature.dao;


import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.domain.Users;
import com.revature.exception.InvalidUserException;

public class UsersDaoTest {

	@Test
	public final void loginTest() {
		UsersDao uDao = new UsersDaoImpl();
		try {
			Users u = uDao.login("test", "test");
			assertNotNull(u);
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
	
}
