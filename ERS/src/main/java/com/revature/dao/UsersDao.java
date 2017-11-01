package com.revature.dao;

import com.revature.domain.Reimbursements;
import com.revature.domain.Users;

public interface UsersDao {
	
	public default boolean  userlogin(String username, String password) {
		// TODO Auto-generated method stub
		return username != null;
	}
	

	
}
