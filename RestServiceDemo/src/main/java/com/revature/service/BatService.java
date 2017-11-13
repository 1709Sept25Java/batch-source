package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Bat;
import com.revature.dao.BatDao;

@Service(value="batService")
public class BatService {
	
	@Autowired
	BatDao batDao;
	
	public List<Bat> getBats(){
		return batDao.findAll();
	}
	
}