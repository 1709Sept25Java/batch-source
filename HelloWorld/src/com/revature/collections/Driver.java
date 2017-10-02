package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.media.*;

public class Driver {

	public static void main(String[] args) {

		//funWithLists();
		
		funWithMaps();

	}

	public static void funWithLists() {

		List<Media> mediaList = new ArrayList<Media>();

		Book b1 = new Book("Charles Darwin", "On the Origin of Species", 1859, "nonfiction");
		Book b2 = new Book("Barack Obama", "Dreams from My Father", 1995, "memoir");
		Movie m1 = new Movie("", "House of Cards", 2013, "drama");
		Movie m2 = new Movie("", "The Fast and the Furious", 2001, "action");

		mediaList.add(b1);
		mediaList.add(b2);
		mediaList.add(m1);
		mediaList.add(m2);

		// print out list elements using instanceof
		for (Media m : mediaList) {
			if (m instanceof Book) {
				System.out.println(m.getTitle());
			}
		}

		// is our list a LinkedList?
		boolean isLinked = mediaList instanceof LinkedList<?>;
		System.out.println("mediaList is a LinkedList: " + isLinked);

		// print out list elements with iterator and a while loop
		// remove any elements published after 2005
		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = it.next();
			System.out.println(m.toString());
			if (m.getYearPublished() >= 2005) {
				it.remove();
			}
		}

		// print out list elements without House of Cards
		for (Media m : mediaList) {
			System.out.println(m.toString());

		}

	}
	
	public static void funWithMaps(){
		//create a new HashMap with key-value pairs 
		Map<Integer,Media> hashMap = new HashMap<>();
		
		Book b1 = new Book("Charles Darwin", "On the Origin of Species", 1859, "nonfiction");
		Book b2 = new Book("Barack Obama", "Dreams from My Father", 1995, "memoir");
		Movie m1 = new Movie("", "House of Cards", 2013, "drama");
		Movie m2 = new Movie("", "The Fast and the Furious", 2001, "action");
		
		hashMap.put(1, b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
		System.out.println(hashMap);
		
		//no duplicate keys, will replace the previous value for that key 
		hashMap.put(2, new Book("Dr. Seuss","The Lorax", 1971,"allegory"));
		
		System.out.println(hashMap.get(2)); //how to retrieve elements 
		
		System.out.println("size of hashMap: "+hashMap.size());
		
		//While Maps are not Collections, the EntrySet of a Map IS a Collection! 
		//(implementation of Set)
		for (Entry<Integer,Media> entry : hashMap.entrySet()){
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			System.out.println(entry.toString());
		}
		
	}

}