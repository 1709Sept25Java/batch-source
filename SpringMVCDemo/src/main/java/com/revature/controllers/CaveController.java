package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Cave;

@Controller
@RequestMapping("/cave")
public class CaveController {
	
	//you might want to wire in a @Service or @Repository to provide CRUD functionality on your domain objects
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getCave(@PathVariable String id, Model m){
		//can (and should) be calling other code here! 
		//for example, a DAO which serves up a Cave with the requested ID. 
		m.addAttribute("caveId",id);
		m.addAttribute("caveName","Manhattan");
		return "cave";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String getCaveInfo(Model m){
		m.addAttribute("cave",new Cave());
		return "newCave";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String addCaveInfo(@Valid Cave cave, BindingResult br, Model m){
		if(br.hasErrors()){
			Object errors  = br.getAllErrors();
			m.addAttribute("errors",errors);
			return "newCave";
		}else{
		m.addAttribute("caveId",cave.getId());
		m.addAttribute("caveName",cave.getName());
		return "newCave";
		}
	}
	
	@GetMapping(value="/JSONcaves")
	@ResponseBody
	 public List<Cave> getCavesList() {
		Cave c1 = new Cave();
		c1.setId(1);
		c1.setName("Room 220");
		Cave c2 = new Cave();
		c2.setId(2);
		c2.setName("Austria");
		Cave c3 = new Cave();
		c3.setId(3);
		c3.setName("Howe Caverns");
		List<Cave> caveList = new ArrayList<>();
		caveList.add(c1);
		caveList.add(c2);
		caveList.add(c3);
		return caveList;
	 }
	
	@GetMapping(value="/staticCaves")
	public String getStaticCavesPage(){
		return"forward:/static/StaticCaves.html";
	}
	 
	
}
