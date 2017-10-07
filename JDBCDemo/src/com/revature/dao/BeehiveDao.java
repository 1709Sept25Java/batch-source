package com.revature.dao;

import java.util.List;

import com.revature.domain.*;
public interface BeehiveDao {
	public List<Beehive> getBeehives();
	
	public Beehive getBeehiveById(int id); 
	
	public boolean updateBeehiveWeight(int id, int delta);
}
