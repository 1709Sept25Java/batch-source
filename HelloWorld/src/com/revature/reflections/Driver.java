package com.revature.reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import com.revature.media.*;

public class Driver {

	public static void main(String[] args) {

		// problems with generic type safety
		Book b1 = new Book("Charles Darwin", "On the Origin of Species", 1859, "Nonfiction");
		Book b2 = new Book("Barack Obama", "Dreams from my Father", 1995, "Memoir");
		// Book b3 = (Book) notGeneric(b1); -- does not work -- throws
		// ClassCastException, but compiles
		Book b3 = genericMethod(b1);

		Movie m1 = new Movie("", "Iron Man", 2008, "Action");
		List<Media> mediaList = new LinkedList<Media>();
		mediaList.add(b1);
		mediaList.add(b2);
		mediaList.add(m1);

		//System.out.println("amount of media objects: " + shelfLength(mediaList));
		//getTitles(mediaList);
		
		//funWithReflections();
		
		List<Object> objectList = new LinkedList<>();
		objectList.add(new Integer(5));
		objectList.add("This is a string");
		objectList.addAll(mediaList);
		objectList.add(new Boolean("True"));
		
		System.out.println(genericReflections(objectList));
	}

	public static Object notGeneric(Object o) {
		return new Integer(3);
	}

	public static <T> T genericMethod(T thing) {
		System.out.println(thing.toString());
		return thing;
	}

	public static int shelfLength(List<Media> l) {
		return l.size();
	}
	public static void getTitles(List<Media> l) {
		for(Media m: l) {
			System.out.println(m.getTitle());
		}
	}
	public static void funWithReflections() {
		try {
			Class clazz = Class.forName("com.revature.media.Media");
			System.out.println(clazz.getName());
			
			//print fields
			Field[] fields = clazz.getDeclaredFields();
			for(Field field: fields) {
				System.out.println(field.getName() + "with a datatype of " + field.getType());
			}
			
			// new instance of Book
			Class clazz2 = Class.forName("com.revature.media.Book");
			Book b4 = (Book) clazz2.newInstance();
			System.out.println(b4);
			Field publisher = clazz2.getDeclaredField("publisher");
			publisher.setAccessible(true);
			publisher.set(b4, "Oxford University Press");
			System.out.println(b4);
			
			//check out some methods
			Method[] methods = clazz2.getDeclaredMethods();
			for(Method method: methods) {
				System.out.println(method.toString()); // can invoke methods too
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static <T> T genericReflections(List<T> l) {
	
		for(T item: l) {
			if(item.getClass().getName().equals("com.revature.media.Book")) {
				
				return item;
			}
		}
		return null; 
	}
	
}

