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
import com.revature.beans.Bat;
import com.revature.beans.Cave;
import com.revature.dao.BatDao;
import com.revature.service.BatService;
@RestController
@RequestMapping(value="/bat")
public class BatController {
	@Autowired 
	BatService bs; // we skipped a step and just wired in our batDao. 
					//if we were doing any processing, we should have that in our BatService
	//in fact....
	@Autowired
	BatDao batDao;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Bat> getBats(){
		return batDao.findAll();
	}
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Bat> getBatByName(@PathVariable("name") String name){
		return ResponseEntity.ok(batDao.getBatByName(name));
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Bat createBat(@RequestBody Bat bat){
		if (batDao.save(bat) != null){
			return bat;
		} else {
			return null;
		}
	}
}