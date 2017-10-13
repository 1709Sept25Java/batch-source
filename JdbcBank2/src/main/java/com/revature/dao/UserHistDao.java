package com.revature.dao;

import java.util.List;

import com.revature.domain.UserHist;

public interface UserHistDao {

	public List<UserHist> getHistory(int id);
	
	public void recordHist(int id);
	
}
