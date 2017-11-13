package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.dao.*;

@CrossOrigin(origins="http://localhost:8082")
@RestController
@RequestMapping(value="/author")
public class AuthorController {

	@Autowired
	AuthorDao AuthorDao;
	
	//retrieve all authors
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Author> getAuthors(){
		return AuthorDao.findAll();
	}
	
	//retrieve author by id
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Author> findOne(@PathVariable("id") int id){
		return ResponseEntity.ok(AuthorDao.findOne(id));
	}
	
	//retrieve author by firstname
	@RequestMapping(value="/{firstname}", method=RequestMethod.GET)
	public ResponseEntity<Author> getAuthorByFirstname(@PathVariable("firstname") String firstname){
		return ResponseEntity.ok(AuthorDao.getAuthorByFirstname(firstname));
	}
	
	//retrieve author by lastname
	@RequestMapping(value="/{lastname}", method=RequestMethod.GET)
	public ResponseEntity<Author> getAuthorByLastname(@PathVariable("lastname") String lastname){
		return ResponseEntity.ok(AuthorDao.getAuthorByFirstname(lastname));
	}
	
	//create new author
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public @ResponseBody Author createAuthor(@RequestBody Author author) {
		if(AuthorDao.save(author) != null) {
			return author;
		}else {
			return null;
		}
	}
	
	//update author
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Author> updateAuthor(@PathVariable("id") int id, @RequestBody Author author){
		Author a = AuthorDao.findOne(id);
		a.setFirstname(author.getFirstname());
		a.setLastname(author.getLastname());
		
		return ResponseEntity.ok(AuthorDao.save(a));

	}

	//delete author
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteAuthor(@PathVariable("id") int id){
		Author a = AuthorDao.findOne(id);
		AuthorDao.delete(a);
		
		return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
	}
	
	//delete all authors
	@RequestMapping(value="/", method=RequestMethod.DELETE)
	public ResponseEntity<Author> deleteAllAuthors(){
		AuthorDao.deleteAll();
		
		return new ResponseEntity<Author>(HttpStatus.NO_CONTENT);
	}
}
