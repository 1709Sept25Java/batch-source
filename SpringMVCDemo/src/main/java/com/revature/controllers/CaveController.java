package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Cave;

@Controller
@RequestMapping("/cave")
public class CaveController {

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getCave(@PathVariable String id,Model m) {
		//can (and should) be calling other code here!
		//for example, a DAO which serves up a Cave with the request ID.
		m.addAttribute("caveId",id);
		m.addAttribute("caveName","Manhattan");
		return "cave";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String getCaveInfo(Model m) {
		m.addAttribute("cave", new Cave());
		return "newCave";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String addCaveInfo(Cave cave,BindingResult br,Model m) {
		m.addAttribute("caveId",cave.getId());
		m.addAttribute("caveName",cave.getName());
		return "newCave";
	}
	
}
