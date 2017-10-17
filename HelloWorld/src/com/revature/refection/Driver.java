package com.revature.refection;

import com.revature.medi.Book;
import com.revature.medi.Movie;

public class Driver {

	public static void main(String[] args) {
		
		// problem with generic type saftey - compiles but prints error 
		Book b1 = new Book("Charles Darwin", "On the Origin of Species", 1859, "notification'");
		Book b2 = new Book("Barack Obama","Dreams from My Father", 1995,"memoir");
		//Book b3 = (Book) notGeneric(b1);
		

	}
	
	public static Object notGeneric(Object o) {
		return new Integer(3);
		
	}
	
	public static <T> T genericMethos(T Thing) { //takes something and returns something of the same thing 
		
	}

}
