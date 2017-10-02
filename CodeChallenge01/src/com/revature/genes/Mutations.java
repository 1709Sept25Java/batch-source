package com.revature.genes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mutations {

	public int minMutations(String start, String end, String[] bank,int count){
		
		//int count=0;
		//return 0 if start and end are the same string
		if(start.equals(end)) {
			return count;
		}
		
		//Store the possible mutations you can take with the differences
		ArrayList index = new ArrayList() {};
		List<String> mutant = new ArrayList<>();
		for(int i=0; i<start.length();i++) {
			if(start.charAt(i)!=end.charAt(i)) {
				index.add(i);
				char[] temp=start.toCharArray();
				temp[i]=end.charAt(i);
				String str = new String(temp); 
				//check if the mutation is valid and store if so
				if(checkBank(str,bank)) {
					mutant.add(str);
				}
				//if only one mutation is needed return 1
				if(start.equals(str)) {
					count++;
					return count;
				}
			}
		}
		
		//if there is no possible mutation return -1
		if(mutant.isEmpty()) {
			return -1;
		}
		
		count++;
		int changes = count; //this was meant to be changes = Integer.MAX_VALUE 
							 //the function as is will only return 0, 1 or -1
		Iterator<String> it = mutant.iterator();
		while(it.hasNext()) {
			String str = it.next();
			int i = minMutations(str,end,bank,count);
			if(i!=-1 && i<changes) {
				changes=i;
			}
		}
		
		return changes;
	}
	
	public boolean checkBank(String mutant, String[] bank) {
		
		for(String s : bank) {
			if(s.equals(mutant)) {
				return true;
			}
		}
		
		return false;
	}
	
}
