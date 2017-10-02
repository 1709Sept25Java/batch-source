package com.revature.challenge1;

import java.util.ArrayList;
	
public class AnalyzeMutations {
		public AnalyzeMutations() {
			super();
		}
	
		public int minimumMutations(String start, String end, ArrayList<String> bank) {
			int mutations = 0;

			if (start.equals(end)) {
				return 0;
			}
			char[] mutatedGene = start.toCharArray(); 
			for (int i=0; i<start.length(); i++){
				if (start.charAt(i) != end.charAt(i)) {
					mutatedGene[i] = end.charAt(i);
					mutations++;
					/*
					 *  Checking if gene is valid 
					 *  Attempted to check strings with mutations as soon as I encountered mutation
					*/
					
				}	
			}
			
			/*
			 * The mutated gene should be checked after finding out 
			 * how many mutations there are in the string
			 */
			if (validGene(mutatedGene,bank)) {
				return mutations;
			}
			return -1;
		}

		public boolean validGene(char mutations[], ArrayList<String> bank) {
			for (String gene:bank) {
				//System.out.println("Mutation: " + String.valueOf(mutations));
				if (gene.equals(String.valueOf(mutations))) {
					//System.out.println("Valid mutation: " + mutation + " " + gene);
					return true;
				}
			}
			return false;
		}
}
