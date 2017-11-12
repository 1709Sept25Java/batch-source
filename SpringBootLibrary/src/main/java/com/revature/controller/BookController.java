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

import com.revature.beans.Book;
import com.revature.beans.Author;
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
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
		return ResponseEntity.ok(BookDao.getBookById(id));
	}
	
	
	//Add book
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public Book createBook(@RequestBody Book book){
			if (BookDao.save(book) != null){
				return book;
			} else {
				return null;
			}
		}
		
		//Update book
		@RequestMapping(value="/{id}",method=RequestMethod.PUT)
		public ResponseEntity<Book> updateBookById(@PathVariable("id") int id, @RequestBody Book bookDetails){
			Book book = BookDao.findOne(id); 
			if (book == null) {
				return null;
			}
			book.setId(bookDetails.getId());
			book.setTitle(bookDetails.getTitle());
			book.setAuthor(bookDetails.getAuthor());
			Book updatedBook = BookDao.save(book);
			return ResponseEntity.ok(updatedBook);
		}
		
		//Delete author
		@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
		public ResponseEntity<Book> deleteBookById(@PathVariable(value="id")int id) {
			Book book = BookDao.findOne(id);
			if (book==null) {
				return null;
			}
			BookDao.delete(book);
			return ResponseEntity.ok().build();
		}
}