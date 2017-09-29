package com.revature.building;

import java.util.Scanner;

//let's pretend this room is a rectangle...
public class ThisRoom extends Room{
	
	protected Boolean isLocked; //private for most part but can be inherited 
	
	public void unlockDoor() {
		//get passcode from user
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter the passcode");
		String passString = sc.nextLine();
		Integer passEntered = Integer.parseInt(passString);
		//validate against the existing passcode 
		if(passEntered.equals(this.passcode)) {
			this.isLocked = false;
			System.out.println("the door is unlocked");
		}
		else {
			this.isLocked = true;
		}
		sc.close();
		
	}

	private Double side1;
	private Double side2;
	private Integer passcode = 12345;
	
	public void setSide1(Double side1) {
		this.side1 = side1;
	}
	
	public void setSide2(Double side2) {
		this.side2 = side2;
	}

	
	public ThisRoom(Double side1, Double side2) {
		super();
		this.side1 = side1;
		this.side2 = side2;
	}
	
	
	
	

}
