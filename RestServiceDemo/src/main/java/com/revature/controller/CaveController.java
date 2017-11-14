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
import com.revature.beans.Cave;
import com.revature.beans.Cave;
import com.revature.dao.CaveDao;
@RestController
@RequestMapping(value="/cave")
public class CaveController {
	@Autowired
	CaveDao CaveDao;
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Cave> getCaves(){
		return CaveDao.findAll();
	}
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Cave> getCaveByName(@PathVariable("name") String name){
		return ResponseEntity.ok(CaveDao.getCaveByName(name));
	}
	@RequestMapping(value="/{max}",method=RequestMethod.GET)
	public ResponseEntity<Cave> guessMaxBears(@PathVariable("max") int max){
		return ResponseEntity.ok(CaveDao.guessMaxBears(max));
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Cave createCave(@RequestBody Cave cave){
		if (CaveDao.save(cave) != null){
			return cave;
		} else {
			return null;
		}
	}
}