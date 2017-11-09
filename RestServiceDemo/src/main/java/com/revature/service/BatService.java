package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.BatDao;
import com.revature.domain.Bat;

@Service(value="batService")
public class BatService {

	@Autowired
	BatDao batDao;
	
	public List<Bat> getBats(){
		return batDao.findAll();
	}
	
}
