package com.revature.homework;

import java.lang.reflect.Field;

import com.revature.question11.Floaters;

public class Question11 {
	
	public static void main(String[] args) {
		
		try {
			Class clazz = Class.forName("com.revature.question11.Floaters");
			
			Floaters f1= (Floaters) clazz.newInstance();
			Field n1 = clazz.getDeclaredField("one");
			Field n2 =clazz.getDeclaredField("two");
			
			n1.setAccessible(true);
			n1.set(f1, (float)3.0);
			
			n2.setAccessible(true);
			n2.set(f1, (float)16.5);
			
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
