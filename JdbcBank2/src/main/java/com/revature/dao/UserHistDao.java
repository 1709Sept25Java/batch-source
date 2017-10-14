package com.revature.dao;

import java.util.List;

import com.revature.domain.UserHist;

public interface UserHistDao {

	//Function to view the User History recorded
	public List<UserHist> getHistory(int id);
	
	//Function to record User history
	public void recordHist(int uId, int baId, String type);
	
}
