package com.revature.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component(value="batClient")
public class BatClient {

	private String resourceUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	
	/*
	 *	public ArrayList<Bat> getBats() {
	 *		ResponseEntity<? extends ArrayList<Bats>> response = 
	 *		this.restTemplate.getForEntity(this.resourceUrl+"/bat/all",(Class<? extends ArrayList<Bats>>))
	 *
	 *	}
	 * 
	*/
	
}
