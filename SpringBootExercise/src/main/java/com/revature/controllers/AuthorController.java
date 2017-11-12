package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.dao.AuthorDao;

@CrossOrigin(origins="http://localhost:8082")
@RestController
@RequestMapping(value="/author")
public class AuthorController {

	@Autowired
	AuthorDao aDao;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Author> getAuthors() {
		return aDao.findAll();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public Author getAuthorById(@PathVariable("id") int id) {
		return aDao.getAuthorById(id);
	}
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ResponseEntity<String> createAuthor(@RequestBody Author author) {
		System.out.println(author);
		if(aDao.save(author) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
