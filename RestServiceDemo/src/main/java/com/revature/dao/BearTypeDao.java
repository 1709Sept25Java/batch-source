package com.revature.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.BearType;

@Repository
public interface BearTypeDao extends JpaRepository<BearType,Integer>{

}