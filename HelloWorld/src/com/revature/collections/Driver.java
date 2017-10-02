package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.media.*;

public class Driver {

	public static void main(String[] args) {
		//funWithList();
		funWithMaps();
	}

	public static void funWithList() {
		List<Media> mediaList = new ArrayList<Media>();
		Book b1 = new Book ("Charles Darwin", "On the Origin of Species",1859,"Nonfiction");
		Book b2 = new Book ("Barack Obama", "Dreams from my Father" , 1995, "Memoir");
		Movie m1 = new Movie ("","House of Cards", 2013, "drama");
		Movie m2 = new Movie ("", "The Fast and Furious", 2009,"Action");
		
		mediaList.add(b1);
		mediaList.add(b2);
		mediaList.add(m1);
		mediaList.add(m2);
		
		//print out list elements using instanceof
		for(Media m : mediaList) {
			if(m instanceof Book) {
				System.out.println(m.getTitle());
			}
			//System.out.println(m.getTitle());
		}
		//is our list a LinkedList?
		boolean isLinked = mediaList instanceof LinkedList<?>;
		System.out.println("meddiaList is a LinedList: " + isLinked);
		
		//print out list elements with iterator and a while loop
		//Remove any elements published after 2005
		Iterator <Media> it = mediaList.iterator();
		while(it.hasNext()) {
			Media m = it.next();
				
			System.out.println(m.toString());
			if(it.next().getYearPublished() >= 2005) {
				it.remove();
			}
			
		}
		
		//prints out without house of cards
		for(Media m : mediaList) {
			//if(m instanceof Book) {
				System.out.println(m.toString());
			//}
		}
		
	}
	
	public static void funWithMaps() {
		//Create a new HashMap with key-values pairs
		// have to use a wrapper because hashmap only deals with objects
		
		Map<Integer,Media> hashMap = new HashMap<>();
		
		Book b1 = new Book ("Charles Darwin", "On the Origin of Species",1859,"Nonfiction");
		Book b2 = new Book ("Barack Obama", "Dreams from my Father" , 1995, "Memoir");
		Movie m1 = new Movie ("","House of Cards", 2013, "drama");
		Movie m2 = new Movie ("", "The Fast and Furious", 2009,"Action");
		
		//use the put to put it in the hashmap
		hashMap.put(1,b1);
		hashMap.put(2, b2);
		hashMap.put(3, m1);
		hashMap.put(4, m2);
		
		System.out.println(hashMap);
		
		//no duplicate keys, will replace the previous value for that key 
		hashMap.put(2, new Book("Dr. Seuss", "The Loras", 1971, "Allegory"));
		
		System.out.println(hashMap.get(2)); // how to retrieve elements 
		
		//size of hashMap
		System.out.println("size of hashMap: " +hashMap.size());
		
		//while Maps are not collections, the EntrySet of a Map IS  a Collection!
		//(implementation of Set
		for(Entry<Integer,Media> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
			System.out.println(entry.toString());
		}
		
	}
}
