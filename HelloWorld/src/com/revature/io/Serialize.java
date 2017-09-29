package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.revature.media.Media;
import com.revature.media.Movie;

public class Serialize {

	public static void main(String[] args) {
		String filename = "src/MediaDemo";
		List<Media> movies = new LinkedList<>();
		movies.add(new Movie("","Up",2009,"family"));
		movies.add(new Movie("","A New Hope",1977,"sci-fi"));
		movies.add(new Movie("","The Fast and Furious",2001,"action"));
		writeObject(filename,movies.get(2));
		readObject(filename);
	}
	
	static void writeObject(String filename, Object obj) {
		//try with resources 
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(obj);
			System.out.println("Wrote to file " + obj.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void readObject(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			Object obj = ois.readObject();
			System.out.println("Read object: " + obj.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
