package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;

public interface UsersDao {

	public Users login(String username,String password);
	
	public List<Users> getUsers(int id);
	
	public boolean deleteUser(int id);
	
	public boolean createUser(String username,String password);
}
