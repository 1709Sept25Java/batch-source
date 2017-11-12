package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.jdbc.BatchedTooManyRowsAffectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	//All authors
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Author> getAuthors(){
		return AuthorDao.findAll();
	}
	
	//Author by id
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Author> getAuthorById(@PathVariable("id") int id){
		Author author = AuthorDao.findOne(id);
		if (author != null) {
			return ResponseEntity.ok().body(author);
		}
		return null;
	}
	
	//Add author
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Author createAuthor(@RequestBody Author author){
		if (AuthorDao.save(author) != null){
			return author;
		} else {
			return null;
		}
	}
	
	//Update author
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Author> updateAuthorById(@PathVariable("id") int id, @RequestBody Author authorDetails){
		Author author = AuthorDao.findOne(id); 
		if (author == null) {
			return null;
		}
		author.setId(authorDetails.getId());
		author.setFirstname(authorDetails.getFirstname());
		author.setLastname(authorDetails.getLastname());
		Author updatedAuthor = AuthorDao.save(author);
		return ResponseEntity.ok(updatedAuthor);
	}
	
	//Delete author
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Author> deleteAuthorById(@PathVariable(value="id")int id) {
		Author author = AuthorDao.findOne(id);
		if (author==null) {
			return null;
		}
		AuthorDao.delete(author);
		return ResponseEntity.ok().build();
	}

	
	
}