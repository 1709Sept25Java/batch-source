package com.revature.service;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;
import java.util.*;

import javax.jws.WebService;

@WebService
public interface Library {
	
	//got to /Library?wsdl to see generated contract (WSDL file) 
	
	public List<Book> getAllBooks();
	public String addBook(Book book) throws LibraryFullException;

}