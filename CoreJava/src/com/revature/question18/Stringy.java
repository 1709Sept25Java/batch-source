package com.revature.question18;

/*
 * Abstract class where the three functions it contains are also abstract.
 * Inheriting classes must implement a checkUpper, makeUpper, and addTen function
 * */
public abstract class Stringy {

	public abstract boolean checkUpper(String str);
	
	public abstract String makeUpper(String str);
	
	public abstract void addTen(String str);
	
}
