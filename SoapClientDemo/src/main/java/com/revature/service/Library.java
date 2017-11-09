package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;

@WebService
public interface Library {

	//go to /Library?wsdl to see the generated wsdl files
	
		public List<Book> getAllBooks();
		public String addBook(Book book) throws LibraryFullException;
	
}
