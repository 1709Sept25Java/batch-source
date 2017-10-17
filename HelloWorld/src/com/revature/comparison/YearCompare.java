package com.revature.comparison;

import java.util.Comparator;

import com.revature.medi.Media;
//import com.revature.medi.Movie;

public class YearCompare implements Comparator<Media> {
	
	public YearCompare(){
		
	}
	
	public int compare(Media m1, Media m2){
		Integer year1 = m1.getYearPublished();
		return year1.compareTo(m2.getYearPublished());
	}
	
	

}