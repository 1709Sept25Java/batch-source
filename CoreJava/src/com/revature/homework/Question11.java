package com.revature.homework;

import java.lang.reflect.Field;

import com.revature.question11.Floaters;

public class Question11 {
	
	public static void main(String[] args) {
		
		//Try catch block to handle Exceptions for reflections
		try {
			//load the class from question11 package
			Class clazz = Class.forName("com.revature.question11.Floaters");
			
			//Create new instance of the class
			Floaters f1= (Floaters) clazz.newInstance();
			Field n1 = clazz.getDeclaredField("one");
			Field n2 =clazz.getDeclaredField("two");
			
			//make the private fields accessible and set the values
			n1.setAccessible(true);
			n1.set(f1, (float)3.0);
			
			n2.setAccessible(true);
			n2.set(f1, (float)16.5);
			
			//print the object to the terminal
			System.out.println(f1);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}

}
