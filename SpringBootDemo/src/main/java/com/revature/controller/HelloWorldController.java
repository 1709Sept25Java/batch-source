package com.revature.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HelloWorldController {

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String message() {
		return "Hello World!";
	}
	
}
