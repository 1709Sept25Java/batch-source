package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

import com.revature.medi.*;

public class Driver {

	public static void main(String[] args) {
		
		funWithLists();

	}
	
	public static void funWithLists() {
		
		// can't create list objects because list is an interface and we can't implement an interface 
		
		List<Media>  mediaList = new ArrayList<Media>(); //define a list, when importing list type, java.util 
		Book b1 = new Book("Charles Darwin", "On the Origin of Species", 1859, "notification'");
		Book b2 = new Book("Barack Obama","Dreams from My Father", 1995,"memoir");
		Movie m1 = new Movie("", "House of Cards", 2013,"drama");
		Movie m2 = new Movie("","The Fast and the Furious", 2001, "action");
		
		mediaList.add(b1);
		mediaList.add(b2);
		mediaList.add(m1);
		mediaList.add(m2);
		
		//print out list elements 
		for(Media m : mediaList) {
			if (m instanceof Book) { //runtime check 
				System.out.println(m.getTitle());	
			}
			
		}
		//is out list a linkedList?
		boolean isLinked = mediaList instanceof LinkedList<?>;
		System.out.println("mediaList is a LinkedList: "+isLinked); //its an array list, will print false 
		
		//print out list elements with iterator ad a while loop 
		//Remove any elements published after 2005
		Iterator<Media> it = mediaList.iterator();
		while (it.hasNext()) {
			Media m = it.next();
			if(m.getYearPublished() >= 2005) {
				it.remove();
			}
			
			
		} 	
			
		}
	// create a new HasMap with key-value pairs 	
			public static void FunWithMaps() {
				Map<Integer,Media> hashMap = new HashMap<>();
				
				Book b1 = new Book("Charles Darwin", "On the Origin of Species", 1859, "notification'");
				Book b2 = new Book("Barack Obama","Dreams from My Father", 1995,"memoir");
				Movie m1 = new Movie("", "House of Cards", 2013,"drama");
				Movie m2 = new Movie("","The Fast and the Furious", 2001, "action");
				
				hashMap.put(1, b1);
				hashMap.put(2, b2);
				hashMap.put(3, m1);
				hashMap.put(4, m2);
				
				System.out.println(hashMap);
				
			//	hashMap.put(2, new Book("Dr. Seuss","The Lorax", 1971,"allegory")); we can't have duplicate keys, 
				
			//	System.out.println(hasMap.get(2)); item number 2 will be replaced, no error 
				
				System.out.println("size of HasMap:"+ hashMap.size()); // Getting the size, = 4, they are not a Collection but the EntrySet which describes all of the entries is a Collection
				
				for (Entry<Integer,Media> entry : hashMap.entrySet()) { //entrySet is an implementation os Set
					System.out.println(entry.getKey()+"\t"+entry.getValue());
					System.out.println(entry.toString());
				}
	} 
			

}
