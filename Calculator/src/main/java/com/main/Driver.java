package com.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.calculations.Calculate;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		System.out.println("1. add");
		System.out.println("2. subtract");
		System.out.println("3. multiple");
		System.out.println("4. divide");
		Scanner sc = new Scanner(System.in);
		int what = sc.nextInt();
		System.out.println("Enter 2 numbers");
		
		Calculate c = (Calculate) ac.getBean("calculate");

		try {
			switch (what) {
			case 1:
				System.out.println(c.add());
				break;
			case 2:
				System.out.println(c.subtract());
				break;
			case 3:
				System.out.println(c.multiple());
				break;
			case 4:
				System.out.println(c.divide());
				break;
			default:
				System.out.println("choose one");
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ac).close();

	}

}
