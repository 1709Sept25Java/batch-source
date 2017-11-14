package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.dao.AuthorDao;


@RestController
@RequestMapping(value="/author")
public class AuthorController {

	@Autowired
	AuthorDao authorDao;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Author> getAuthor(){
		System.out.println("get all authors ");
		return authorDao.findAll();
	}
	
	@RequestMapping(value="/{firstname}",method=RequestMethod.GET)
	public ResponseEntity<Author> getAuthorByFirstname(@PathVariable("firstname") String firstname){
		return ResponseEntity.ok(authorDao.getAuthorByFirstname(firstname));
	}
	@RequestMapping(value="/{lastname}",method=RequestMethod.GET)
	public ResponseEntity<Author> getAuthorByLastname(@PathVariable("lastname") String lastname){
		return ResponseEntity.ok(authorDao.getAuthorByLastname(lastname));
	}
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public Author createAuthor(@RequestBody Author author) {
		if(authorDao.save(author) != null) {
			return author;
			
		}else {
			return null;
		}
	}
}
