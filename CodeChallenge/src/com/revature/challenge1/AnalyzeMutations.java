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
			
			for (int i=0; i<start.length(); i++){
				char[] mutatedGene = start.toCharArray(); 
				int change = -1;
				//System.out.println(mutatedGene);
				if (start.charAt(i) != end.charAt(i)) {
					mutatedGene[i] = end.charAt(i);
					//System.out.println(start + " \n" + String.valueOf(mutatedGene) + " \n" + end + "\n");
					mutations++;
					/* Checking if gene is valid */
					if (validGene(mutatedGene,bank)) {
						mutatedGene = start.toCharArray();
						mutatedGene[i] = end.charAt(i);
						//mutations++;
					}
				}	
			}
			
			if (mutations == 0) {
				return -1;
			}
			
			return mutations;
		}

		public boolean validGene(char mutations[], ArrayList<String> bank) {
			for (String gene:bank) {
				System.out.println("Mutation: " + String.valueOf(mutations));
				if (gene.equals(String.valueOf(mutations))) {
					//System.out.println("Valid mutation: " + mutation + " " + gene);
					return true;
				}
			}
			return false;
		}
}
