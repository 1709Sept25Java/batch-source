package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.*;

@Repository
public interface CaveDao extends JpaRepository<Cave,Integer> {
	public Cave findCaveByName(String name);
}
