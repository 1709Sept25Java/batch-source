package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.beans.Bear;
@Repository
public interface BearDao extends JpaRepository<Bear,Integer>{
	public Bear getBearByName(String name);
	public Bear getBearByWeight(int weight);
}