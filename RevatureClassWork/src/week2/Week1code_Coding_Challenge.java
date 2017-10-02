package week2;

import java.util.Arrays;

public class Week1code_Coding_Challenge {

	private String[] gene1;
	private String[] gene2;
	private int mutations;
	private String[] mutationsbank;
	
	public String[] getGene1() {
		return gene1;
	}

	public void setGene1(String[] gene1) {
		this.gene1 = gene1;
	}
	
	public String[] getGene2() {
		return gene2;
	}

	public void setGene2(String[] gene2) {
		this.gene2 = gene2;
	}
	
	public static void main(String[] args) {
		Week1code_Coding_Challenge cc= new Week1code_Coding_Challenge();
		String[]gene1= new String[]{"AACCGGTA"};
		String[]gene2= new String[]{"AACCGGTT"};
		//cc.geneTypes(gene1,cc.mutationsbank);
		cc.geneTypes(gene1, gene2);
	}
	
	
	public String[] geneBank(String[] gene1)
	{
		//added in later
		String[] leastMutations= {};
		//determine which mutator is the smallest from the bank, and returns the index of it
		String []bank=new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"};

			if((geneTypes(gene1,Arrays.copyOfRange(bank, 0, 0))>geneTypes(gene1,Arrays.copyOfRange(bank, 1,1)))
					&&(geneTypes(gene1,Arrays.copyOfRange(bank, 0,0))>geneTypes(gene1,Arrays.copyOfRange(bank, 2,2))))
			{
				leastMutations=Arrays.copyOfRange(bank, 0,0);
			}
			else if((geneTypes(gene1,Arrays.copyOfRange(bank, 1,1))>geneTypes(gene1,Arrays.copyOfRange(bank, 0,0)))
					&&(geneTypes(gene1,Arrays.copyOfRange(bank, 1,1))>geneTypes(gene1,Arrays.copyOfRange(bank, 2,2))))
			{
				leastMutations=Arrays.copyOfRange(bank, 1,1);
			}
			else 
			{
				leastMutations=Arrays.copyOfRange(bank, 2,2);
			}
			this.mutationsbank=leastMutations;
		return leastMutations;
	}
	
	public int geneTypes(String[] gene1, String[] gene2) 
	{
		int mutations=0;
		this.gene1=gene1;
		this.gene2=gene2;
		//"A", "C", "G", "T";

		for(int i=0; i<8; i++)
		{
				if(gene1[0].substring(0).charAt(i)==gene2[0].substring(0).charAt(i))
				{
					//no added mutations	
				}
				else
				{
					mutations++;
				}
		}
		return mutations(mutations);
	}
	
	public int mutations(int mutations)
	{
		this.mutations=mutations;
		System.out.println("Number of mutations: "+mutations);
		return mutations;
	}

}
