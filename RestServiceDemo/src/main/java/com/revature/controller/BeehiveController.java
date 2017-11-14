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
import com.revature.beans.Beehive;
import com.revature.beans.Cave;
import com.revature.dao.BeehiveDao;
@RestController
@RequestMapping(value="/beehive")
public class BeehiveController {
	@Autowired
	BeehiveDao BeehiveDao;
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Beehive> getBeehives(){
		return BeehiveDao.findAll();
	}
	
	//ResponseEntity: represent the entire HTTP response
	@RequestMapping(value="/{weight}", method=RequestMethod.GET)
	public ResponseEntity<Beehive> getBeehiveByWeight(@PathVariable("weight") int weight){
		return ResponseEntity.ok(BeehiveDao.getBeehiveByWeight(weight));
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Beehive createBeehive(@RequestBody Beehive beehive){
		if (BeehiveDao.save(beehive) != null){
			return beehive;
		} else {
			return null;
		}
	}
}