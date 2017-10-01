package com.revature.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Sort2Employees {

	public static void main(String[] args) {
		sortWithComparator();
	}

	public static void sortWithComparator() {

		ArrayList<Employees> list = new ArrayList<Employees>();
		list.add(new Employees("Charlie", "IT", 23));
		list.add(new Employees("Ajay", "Finance", 27));
		System.out.println("Sorting by Name: ");

		Collections.sort(list, new NameComparator());
		Iterator<Employees> itr1 = list.iterator();
		while (itr1.hasNext()) {
			Employees st = (Employees) itr1.next();
			System.out.println("Name: "+st.name + " Department: " + st.department + " Age: " +st.age);
		}

		System.out.println("Sorting by age: ");

		Collections.sort(list, new AgeComparator());
		Iterator<Employees> itr2 = list.iterator();
		while (itr2.hasNext()) {
			Employees st = (Employees) itr2.next();
			System.out.println("Age: "+st.age +" Name: " + st.name+ " Department: " + st.department);
		}
		System.out.println("Sorting by department: ");

		Collections.sort(list, new DepComparator());
		Iterator<Employees> itr3 = list.iterator();
		while (itr3.hasNext()) {
			Employees st = (Employees) itr3.next();
			System.out.println("Department: "+st.department +" Name: " + st.name+ " Age: " + st.age);
		}

	}

}
