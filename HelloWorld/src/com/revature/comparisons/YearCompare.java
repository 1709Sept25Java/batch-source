package com.revature.comparisons;

import java.util.Comparator;

import com.revature.media.Media;
//import com.revature.media.Movie;

public class YearCompare implements Comparator<Media> {
	
	public YearCompare(){
		
	}
	
	public int compare(Media m1, Media m2){
		Integer year1 = m1.getYearPublished();
		return year1.compareTo(m2.getYearPublished());
	}
	
	

}