package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	
	public Book getBookByTitle(String name);
	
	public Book getBookByAuthorFirstname(String firstname);
	
	public Book getBookByAuthorLastname(String lastname);
}
