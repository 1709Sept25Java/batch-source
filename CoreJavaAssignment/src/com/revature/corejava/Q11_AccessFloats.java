package com.revature.corejava;

import com.revature.corejavafloats.*;

public class Q11_AccessFloats {

	public static void main(String[] args) {
		System.out.println(
				"Floats from package com.revature.corejavafloats are " + Floats.getx() + " and " + Floats.gety());
	} //prints floats from class "Floats" where two floats have been declared static and public
	  //so that they can be accessed from this package, but an object need not be instantiated to so
}
