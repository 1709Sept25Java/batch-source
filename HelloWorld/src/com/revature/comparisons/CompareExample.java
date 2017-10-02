package com.revature.comparisons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.media.Movie;

public class CompareExample {

	public static void main(String[] args) {

		ArrayList<Movie> list = new ArrayList<>();
		list.add(new Movie("","UP", 2009, "Family"));
		list.add(new Movie("","A New Hope", 1977,"Sci-fi"));
		list.add(new Movie("","The Fast and the Furious", 2001,"Action"));
		
		System.out.println("Movies, originally:" + list);
		for (Movie m : list) {
			System.out.println(m);
		}
		/*sortWithComparable(list);
		System.out.println("movies, after sortWithComparable: "+ list);
		for (Movie m : list) {
			System.out.println(m);
		}*/
		sortWithComparator(list);
	}
	public static List<Movie> sortWithComparable(List<Movie> l){
		Collections.sort(l);
		System.out.println("movies, after sortWithComparable: ");
		for (Movie m : l) {
			System.out.println(m);
		}
		return l; 
	}
	public static List<Movie> sortWithComparator(List<Movie> l){
		YearCompare yc = new YearCompare();
		
		Collections.sort(l, yc);// could write multiple comparator and swap them out
		System.out.println("movies, after sortWithComparator: ");
		for (Movie m : l) {
			System.out.println(m);
		}
		return l;
	}

}
