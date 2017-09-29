package com.revature.building;

public abstract class Room {

	public Boolean isLocked;
	
	//concrete method has implementation 
	public void openDoor() {
		if(isLocked) {
			System.out.println("door is locked");
		}else {
			System.out.println("door is open");
		}
	}
	
	//abstract method - no implementation 
	public abstract void unlockDoor();

}
