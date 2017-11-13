package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Author;

public interface AuthorDao extends JpaRepository<Author, Integer>{
	
	public Author getAuthorByFirstname(String firstname);
	
	public Author getAuthorByLastname(String lastname);
	
}
