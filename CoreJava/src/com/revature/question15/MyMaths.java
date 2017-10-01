package com.revature.question15;

/*
 * Class that implements the BasicMath class. Has a default constructor.
 * */
public class MyMaths implements BasicMath {

	public MyMaths() {
		super();
	}

	@Override
	public int addition(int a,int b) {
		return a+b;
	}

	@Override
	public int subtration(int a,int b) {
		return a-b;
	}

	@Override
	public int multiplication(int a,int b) {
		return a*b;
	}

	@Override
	public int division(int a,int b) {
		return a/b;
	}

}
