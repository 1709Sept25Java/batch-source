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

import com.revature.beans.Book;
import com.revature.dao.*;

@CrossOrigin(origins="http://localhost:8080")
@RestController
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	BookDao BookDao;

	//retrieve all books
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Book> getBooks(){
		return BookDao.findAll();
	}
	
	//retrieve book by title
	@RequestMapping(value="/{title}", method=RequestMethod.GET)
	public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title){
		return ResponseEntity.ok(BookDao.getBookByTitle(title));
	}
	
	//retrieve book by book's firstname
	@RequestMapping(value="/{firstname}", method=RequestMethod.GET)
	public ResponseEntity<Book> getBookBybookFirstname(@PathVariable("firstname") String firstname){
		return ResponseEntity.ok(BookDao.getBookByAuthorFirstname(firstname));
	}
	
	//retrieve book by book's lastname
	@RequestMapping(value="/{lastname}", method=RequestMethod.GET)
	public ResponseEntity<Book> getBookBybookLastname(@PathVariable("lastname") String lastname){
		return ResponseEntity.ok(BookDao.getBookByAuthorLastname(lastname));
	}
	
	//create new book 
	@RequestMapping(value="/new",method=RequestMethod.POST)
	public @ResponseBody Book createBook(@RequestBody Book book) {
		if(BookDao.save(book) != null) {
			return book;
		}else {
			return null;
		}
	}
	
	//update a book
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book){
		Book b = BookDao.findOne(id);
		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());
		
		return ResponseEntity.ok(BookDao.save(b));

	}
	
	//delete a book
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteBook(@PathVariable("id") int id){
		Book b = BookDao.findOne(id);
		BookDao.delete(b);
		
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
	
	//delete all books
		@RequestMapping(value="/", method=RequestMethod.DELETE)
		public ResponseEntity<Book> deleteAllBooks(){
			BookDao.deleteAll();
			
			return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
		}
}
