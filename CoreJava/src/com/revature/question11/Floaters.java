package com.revature.question11;

/*
 * A class comprised of two floats with no getter/setter functions, a default
 * constructor and a toString function override
 * */
public class Floaters {

	public Floaters() {
		super();
	}

	private float one;
	
	private float two;

	@Override
	public String toString() {
		return "Floaters [one=" + one + ", two=" + two + "]";
	}
	
}
