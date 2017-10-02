package com.revature.building;

public abstract class Room {
	
	protected boolean isOpen; 
	protected RoomType type;
	//Boolean is capped because you want to treat it as a wrapper- by default is false
	//protected - field is mostly private but you want it to be inheritable to another class
	//concrete method- has implementation
	public void openDoor() {
		if(!isOpen) {
			System.out.println("Door is locked");
		}else {
			System.out.println("Door is open");
		}
		
	}
	// abstract method- no implementation 
	public abstract void unlockedDoor();

}
