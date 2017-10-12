package com.revature.dao;

import java.util.List;
import com.revature.domain.*;
public interface BeehiveDao {

	public List<Beehive> getBeeHives();
	public Beehive getBeehivebyId(int id);
	public boolean updateBeehiveWeight(int id, int delta);
}
