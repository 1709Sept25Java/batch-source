package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library {
	
	@Override
	public List<Book> getAllBooks(){
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book("Slaughterhouse-Five","Kurt Vonnegut",1969));
		bookList.add(new Book("White Teeth","Zadie Smith",2000));
		bookList.add(new Book("White Fang","Jack London",1906));
		return bookList;
	}
	
	@Override 
	public String addBook(Book book) throws LibraryFullException {
		if(book.getYear()==1999){
			//this is pretty arbitrary
			throw new LibraryFullException("Library full. Cannot add book: "+book);
		}
		return "successfully added book by: "+book.getAuthor();
	}
}
