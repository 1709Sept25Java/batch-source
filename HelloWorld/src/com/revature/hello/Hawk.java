package com.revature.hello;

public class Hawk extends Raptor {
	
	public Hawk(){
		super(); //this is added by compiler if we don't include it
		System.out.println("hawk constructor");
	}

/*	public static void main(String[] args) {
		System.out.print("init ");
		new Hawk();
		System.out.println("hawk ");

	}
*/
}

class Raptor extends Bird {
	static {
		System.out.print("r1 ");
	}

	public Raptor() {
		System.out.print("r2 ");
	}

	{
		System.out.print("r3 ");
	}
	static {
		System.out.print("r4 ");
	}

}
class Bird {
	{
		System.out.print("b1 ");
	}

	public Bird() {
		System.out.print("b2 ");
	}

	static {
		System.out.print("b3 ");
	}
}
