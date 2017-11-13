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

import com.revature.beans.Book;
import com.revature.dao.BookDao;

@RestController
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	BookDao BookDao;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Book> getBooks(){
		return BookDao.findAll();
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Book> getCaveById(@PathVariable("id") int id){
		return ResponseEntity.ok(BookDao.getBookById(id));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Book createCave(@RequestBody Book book){
		if (BookDao.save(book) != null){
			return book;
		} else {
			return null;
		}
	}
}