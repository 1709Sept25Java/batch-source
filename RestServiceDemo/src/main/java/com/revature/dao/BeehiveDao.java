package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Bear;
import com.revature.beans.Beehive;

@Repository
public interface BeehiveDao extends JpaRepository<Beehive,Integer>{
	public Beehive getBeehiveByWeight(int weight);
}
