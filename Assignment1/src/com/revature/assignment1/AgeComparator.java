package com.revature.assignment1;

import java.util.*;

public class AgeComparator implements Comparator<Object> {

	public int compare(Object o1, Object o2) {

		Employees e1 = (Employees) o1;
		Employees e2 = (Employees) o2;

		if (e1.age == e2.age) {
			return 0;

		} else if (e1.age > e2.age) {
			return 1;

		}else {
			return -1;
		}

	}
}
