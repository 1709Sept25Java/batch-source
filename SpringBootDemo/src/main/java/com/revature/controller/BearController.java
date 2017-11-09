package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.jdbc.BatchedTooManyRowsAffectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.dao.BearDao;

@RestController
@RequestMapping(value="/bear")
public class BearController {
	
	@Autowired
	BearDao BearDao;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Bear> getBears(){
		return BearDao.findAll();
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Bear> getBearByName(@PathVariable("name") String name){
		return ResponseEntity.ok(BearDao.getBearByName(name));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Bear createBear(@RequestBody Bear bear){
		if (BearDao.save(bear) != null){
			return bear;
		} else {
			return null;
		}
	}
}
