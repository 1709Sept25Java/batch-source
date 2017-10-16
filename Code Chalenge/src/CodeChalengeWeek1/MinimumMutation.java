package CodeChalengeWeek1;

import java.util.LinkedHashSet;
import java.util.Queue;

public class MinimumMutation {

	public int findMutatedGene(String start, String end, String[] bank) {
		int count = 0;
		
		if (start.length() != end.length()) return -1;
		{
			Queue<String> str = (Queue<String>) new LinkedHashSet<String>();
			str.add(start);
			
			LinkedHashSet<String> temp = new LinkedHashSet<String>();
			while (!str.isEmpty()) {
				String tmp = str.poll();
				if((end)) return count;
						
			}
				
				
				
		}
		return count;
	
	}
}
