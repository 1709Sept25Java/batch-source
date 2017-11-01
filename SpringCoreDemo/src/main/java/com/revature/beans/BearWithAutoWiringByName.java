package com.revature.beans;

public class BearWithAutoWiringByName extends Bear{

	private Cave cave;
	
	//Method identifier must match name of dependency or cave won't added
	public void setCave(Cave cave){
		this.cave = cave;
	}

	@Override
	public void methodInBear() {
		System.out.println("method in BearWithAutoWiringByName, this is: "+this.toString());
		System.out.println("cave: "+cave.toString());
		
	}
	
}
