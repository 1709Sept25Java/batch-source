package com.revature;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Author;
import com.revature.beans.Book;

public class TestClient {

    public static final String REST_SERVICE_URI = "http://localhost:8084";

    @Autowired
	private static RestTemplate restTemplate;
    
    //get all authors
    public static ArrayList<Author> getAllAuthors() {

        ResponseEntity<? extends ArrayList<Author>> response = 
                restTemplate.getForEntity(REST_SERVICE_URI+"/author/all", (Class<? extends ArrayList<Author>>)ArrayList.class);
        return response.getBody();
    }
    
    //get all books
    public static ArrayList<Book> getAllBooks() {
        ResponseEntity<? extends ArrayList<Book>> response = 
                restTemplate.getForEntity(REST_SERVICE_URI+"/book/all", (Class<? extends ArrayList<Book>>)ArrayList.class);
        return response.getBody();
    }
    
    //get an author
    public static Author getAuthor(int id){
        System.out.println("getting author..");
        RestTemplate restTemplate = new RestTemplate();
        Author a = restTemplate.getForObject(REST_SERVICE_URI+"/author/"+id, Author.class);
        return a;
    }
    
    //get a book
    public static Book getBook(int id){
        System.out.println("getting book..");
        RestTemplate restTemplate = new RestTemplate();
        Book b = restTemplate.getForObject(REST_SERVICE_URI+"/book/"+id, Book.class);
        return b;
    }
    
    //create new author
    public static void createAuthor(Author a) {
        System.out.println("creating new author..");
        RestTemplate restTemplate = new RestTemplate();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/author/", a, Author.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
	public static void main(String[] args) {

		Author a = new Author();
		a.setFirstname("J.K");
		a.setLastname("Rowling");
		
		createAuthor(a);
	}

}
