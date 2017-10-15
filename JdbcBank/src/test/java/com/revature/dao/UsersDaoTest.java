package com.revature.dao;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.domain.Users;
import com.revature.exception.InvalidUserException;

public class UsersDaoTest {

	//Check that the login function works
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
	
	//Check that the function to retrieve users works
	@Test
	public final void viewUsersTest() {
		UsersDao uDao = new UsersDaoImpl();
		List<Users> users = uDao.getUsers(1);
		
		assertNotNull(users);
		
	}
	
}
