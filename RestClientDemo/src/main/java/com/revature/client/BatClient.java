package com.revature.client;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Bat;

@Component(value="batClient")
public class BatClient {
	
	private String resourceUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void setResourceUrl(String resourceUrl){
		this.resourceUrl = resourceUrl;
	}
	
	public ArrayList<Bat> getBats() {
		ResponseEntity<? extends ArrayList<Bat>> response = 
				this.restTemplate.getForEntity(this.resourceUrl+"/bat/all", (Class<? extends ArrayList<Bat>>)ArrayList.class);
		return response.getBody();
	}
	
	public Bat saveBat(Bat bat){
		HttpEntity<Bat> request = new HttpEntity<Bat>(bat);
		return this.restTemplate.postForObject(this.resourceUrl+"/bat", request, Bat.class);
	}

}