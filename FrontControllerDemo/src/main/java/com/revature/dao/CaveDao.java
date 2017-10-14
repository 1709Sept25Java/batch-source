package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface CaveDao {
	
	public List<Cave> getCaves();
	public Cave getCaveById(int id);

}