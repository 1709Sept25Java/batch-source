package com.revature.assignment1.question11;

//Class Variables contained in a different package

public class Variables {

	//Declare variables as private fields
	private float v1;
	
	private float v2; 
	
	//Create constructor
		//Note: initialized variable values upon creation of object
		//They could also be static final variables (constants) 
	public Variables() {
		super();
		v1 = (float) 0.9;
		v2 = (float) 3.1;
	}

	//Get functions to allow retrieval of values 
		//but don't give direct access to variables
	public float getV1() {
		return v1;
	}
	
	public float getV2() {
		return v2;
	}

}
