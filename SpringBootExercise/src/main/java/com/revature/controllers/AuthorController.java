package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	AuthorDao aDao;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Author> getAuthors() {
		return aDao.findAll();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public Author getAuthorById(@PathVariable("id") int id) {
		return aDao.getAuthorById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Author createAuthor(@RequestBody Author author) {
		if(aDao.save(author) != null) {
			return author;
		} else {
			return null;
		}
	}
	
}
