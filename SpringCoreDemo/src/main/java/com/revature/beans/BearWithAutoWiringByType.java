package com.revature.beans;

public class BearWithAutoWiringByType extends Bear{

	private Cave cave;
	
	//this is ok because we're wiring by type, not by the setter name
	public void setOther(Cave other){
		this.cave = other;
	}

	@Override
	public void methodInBear() {
		System.out.println("method in BearWithAutoWiringByType, this is: "+this.toString());
		System.out.println("cave: "+cave.toString());
		
	}
	
}
