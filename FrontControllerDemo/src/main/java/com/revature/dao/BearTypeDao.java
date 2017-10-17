
package com.revature.dao;

import java.util.List;

import com.revature.domain.BearType;

public interface BearTypeDao {
	
	public List<BearType> getBearTypes();
	public BearType getBearTypeById(int id);

}