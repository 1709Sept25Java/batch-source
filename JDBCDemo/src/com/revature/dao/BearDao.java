package com.revature.dao;

public interface BearDao {
	
	public List<Bear> getBears();
	
	public Bear getBearById(int id);
	
	public int feedBear();
	
	public int createBear(Bear bear);
}
