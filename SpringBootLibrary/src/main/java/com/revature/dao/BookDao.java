package com.revature.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.beans.Author;
import com.revature.beans.Book;

@Repository
public interface BookDao extends JpaRepository<Book,Integer>{
	public Book getBookById(int id);

}