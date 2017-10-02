package com.revature.challenge;
import java .util.*;

public class Drive {
	
	public static void main(String[] args) {
		public  static final char[] mut = {'A','C','G','T'};// array that can't be modify 
		
		public int minimumMutation(String start, String end, String[] bank){
			
			Set<String> set = new HashSet<>(Arrays.asList(bank));
			if (!set.contains(end))
			{
				return -1;
			}
			List<Integer> answerList = new ArrayList<>();
			for ( int M = 0 ; M < 4 ; M++) {
				StringBuffer xo = new StringBuffer(start);
				for(int k = 0; k < 4; K++){
					xo.setChartAt(M, mut[k]);
					
				}
			}
			char result = char.Max_Value;
		}
		

	}

}
