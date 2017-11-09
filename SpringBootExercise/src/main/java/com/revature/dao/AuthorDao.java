package com.revature.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Author;

@Repository
public interface AuthorDao extends JpaRepository<Author,Integer>{
	
	public Author getAuthorById(int id);
	
}
