package com.revature.service;
import com.revature.exception.LibraryFullException;
import com.revature.model.Book;
import java.util.*;

import javax.jws.WebService;

@WebService
public interface Library {
	
	//we could also generate this file from the WSDL exposed in our SoapServiceDemo
	
	public List<Book> getAllBooks();
	public String addBook(Book book) throws LibraryFullException;
	public String notRealMethod();

}