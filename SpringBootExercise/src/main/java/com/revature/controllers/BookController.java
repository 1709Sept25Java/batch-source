package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.dao.BookDao;

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
	
	@RequestMapping(method=RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
		if(bDao.save(book) != null) {
			return book;
		} else {
			return null;
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
