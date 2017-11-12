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
import com.revature.beans.Book;
import com.revature.dao.BookDao;

@CrossOrigin(origins="http://localhost:8082")
@RestController
@RequestMapping(value="/book")
public class BookController {

	@Autowired
	BookDao bDao;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Book> getBooks(){
		return bDao.findAll();
	}
	
	@RequestMapping(value="/{title}",method=RequestMethod.GET)
	public Book getBookByTitle(@PathVariable("title") String title) {
		return bDao.getBookByTitle(title);
	}
	
	@RequestMapping(value="/{author}",method=RequestMethod.GET)
	public List<Book> getBookByAuthor(@PathVariable("author") Author author){
		return bDao.getBookByAuthor(author);
	}
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		System.out.println(book);
		if(book.getTitle() != null && bDao.save(book) != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public void deleteBook(@RequestBody Book book, @PathVariable("id")int id) {
		bDao.delete(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public void updateById(@RequestBody Book book, @PathVariable("id")int id) {
		
	}
	
	
	
}
