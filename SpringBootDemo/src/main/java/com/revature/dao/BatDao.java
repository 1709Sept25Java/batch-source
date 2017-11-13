package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Bat;

@Repository
public interface BatDao extends JpaRepository<Bat,Integer>{

	public Bat getBatByName(String name);

}