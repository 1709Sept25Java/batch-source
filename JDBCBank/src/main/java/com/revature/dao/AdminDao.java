package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.domain.*;


public interface AdminDao {
	public ArrayList<User> viewUsers();
	
	public int createUser(String username, String password, String type);

	public boolean updateUser(int userId, String username, String password, String type);
	
	public boolean deleteUser(int userId);
	
}
