package com.revature.codechallenge;
import java.util.LinkedList;
import java.util.Queue;

public class GeneSolution{
	
	public int minMutation(String start, String end, String[] bank) {
	int count = 0;
				
	if(start.length() != end.length()) return -1;
				
	Queue<String> q = new LinkedList<String>();
	char [] mutationChar = {'A','C','G','T'};
	q.add(start);
	while(!q.isEmpty()){
					
	Queue<String> temp = new LinkedList<String>();
	
	while(!q.isEmpty()){
	String tmp = q.poll();
	
	if(tmp.equals(end)) return count;
	
	for(String s:bank){
	
		if(mutation(tmp,s)==1 ){
	temp.add(s);}
	}}
		q = temp;
		count++; }
	return -1;}

	public int mutation(String s1,String s2){
		int count = 0;
		for(int i = 0;i<s1.length();i++){
		if(s1.charAt(i)!=s2.charAt(i)){
			count++;}}
		return count;}		    
}	