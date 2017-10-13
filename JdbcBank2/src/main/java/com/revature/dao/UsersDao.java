package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;
import com.revature.util.ConnectionUtil;

public interface UsersDao {

	public Users login(String username,String password,ConnectionUtil cu);
	
	public List<Users> getUsers(int id,ConnectionUtil cu);
	
	public boolean deleteUser(int id,ConnectionUtil cu);
	
	public boolean createUser(String username,String password,String isAdmin,ConnectionUtil cu);
}
