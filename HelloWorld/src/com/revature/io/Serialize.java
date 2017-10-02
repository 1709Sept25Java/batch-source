package com.revature.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.revature.media.Movie;

public class Serialize {

	public static void main(String[] args) {

		String filename = "src/serializedThings/MediaDemo";
		List<Movie> movies = new LinkedList<>();
		movies.add(new Movie("","UP", 2009, "Family"));
		movies.add(new Movie("","A New Hope", 1977,"Sci-fi"));
		movies.add(new Movie("","The Fast and the Furious", 2001,"Action"));
		
		//serialized it
		writeObject(filename,movies.get(2));
		
		//reading object
		//readObject(filename);
	}

	static void writeObject(String filename, Object obj){
	
		//try with resources 
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(obj);
			System.out.println("wrote to file: "+ obj.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void readObject(String filename) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Object obj= ois.readObject();
			System.out.println("read object: "+ obj.toString());
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
