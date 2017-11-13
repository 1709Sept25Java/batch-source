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

import com.revature.beans.Author;
import com.revature.dao.AuthorDao;
@RestController
@RequestMapping(value="/author")
public class AuthorController {
	
	@Autowired
	AuthorDao AuthorDao;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Author> getAuthors(){
		return AuthorDao.findAll();
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Author> getCaveById(@PathVariable("id") int id){
		return ResponseEntity.ok(AuthorDao.getAuthorById(id));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Author createCave(@RequestBody Author author){
		if (AuthorDao.save(author) != null){
			return author;
		} else {
			return null;
		}
	}
}