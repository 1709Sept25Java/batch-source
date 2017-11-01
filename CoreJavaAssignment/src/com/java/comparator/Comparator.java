package com.java.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.staff.NewYorkStaff;


public class Comparator {

	public static void main(String[] args) {

		ArrayList<NewYorkStaff> list = new ArrayList<>();
		list.add(new NewYorkStaff("John Doe", "Accounting", 27));
		list.add(new NewYorkStaff("Dave Smith", "IT", 29));
		

		System.out.println("Employees Originally");
		for (NewYorkStaff m : list) {
			System.out.println(m);
		}
		
		sortWithComparator(list);

	}
	
	public static List<NewYorkStaff> sortWithComparator(List<NewYorkStaff> l) {

		Compare yc = new Compare();
		Collections.sort(l, yc); 
		System.out.println("Employees, after sortWithComparator: ");
		for (NewYorkStaff m : l) {
			System.out.println(m);
		}
		return l;
	}

}