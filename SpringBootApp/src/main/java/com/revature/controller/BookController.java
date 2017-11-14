package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

@RestController
@RequestMapping(value="/book")
public class BookController {

	@Autowired
	BookDao bookDao;
	//get all book
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Book> getBooks(){
		System.out.println("get all books");
		return bookDao.findAll();
	}
	//get book by title
	@RequestMapping(value="/{title}",method=RequestMethod.GET)
	public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){
		return ResponseEntity.ok(bookDao.getBookByTitle(title));
	}
	//get book by author
	@RequestMapping(value="/{firstname}", method=RequestMethod.GET)
	public List<Book> getBookByAuthor(@PathVariable("firstname") Author author){
		return bookDao.getBookByAuthor(author);
	}
	//create book
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
		if(bookDao.save(book)!=null) {
			return book;
		}else {
			return null;
		}
	}
	//delete book
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") int id, @RequestBody Book book) {
		bookDao.delete(book);
	}
	//update book
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public void updateBook(@PathVariable("id")int id, @RequestBody Book book) {
		
	}
}
