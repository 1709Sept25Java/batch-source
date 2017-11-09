package com.revature.beans;

public interface GenericCalculator {
	
	public abstract Number calc(Number a, Number b, String op);

	public abstract Number add(Number a,Number b);
	
	public abstract Number subtract(Number a,Number b);
	
	public abstract Number multiply(Number a,Number b);
	
	public abstract Number divide(Number a,Number b);
	
}
