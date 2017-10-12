package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface BearDao {

	public List<Bear> getBears();
	public Bear getBearById(int id);
	int createBear(Bear bear);
	int feedBear(int bearId, int hiveId, int amt);
}
