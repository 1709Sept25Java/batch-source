package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;
import com.revature.service.Library;

public class Driver {
	
	public static void main(String[] args) {
		
		//set up Java entity with which to interact 
		
		String serviceUrl = "http://ec2-54-71-133-254.us-west-2.compute.amazonaws.com:8080/SoapServiceDemo/Library";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceUrl);
				
		//set up interceptors for SOAP messages
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
				
		//if only we had a FRAMEWORK to INJECT all these DEPENDENCIES for us programmatically...
		//maybe hold them in a CONTAINER or CONTEXT...
				
		//consume LibraryService
				
		Library library = (Library) factory.create();
		List<Book> bookList = library.getAllBooks();
		for(Book b : bookList){
			System.out.println(b);
		}
				
		//library.notRealMethod();
		
		/*
		Book newBook = new Book("Random Comments and the Inability to Build a Robot","Rebeca Otero",1994);
		try {
			library.addBook(newBook);
		} catch (LibraryFullException e) {
			System.out.println(e.getMessage());;
		}
		*/
	
	}

}