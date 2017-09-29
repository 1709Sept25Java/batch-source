package com.revature.building;

public abstract class Room {
	protected boolean isOpen;
	
	protected RoomType type;
	
	//concrete method has implementation
	
	public void openDoor() {
		if (!isOpen) {
			System.out.println("door is locked");
		}
		else {
			System.out.println("door is open");
		}
	}

	//abstract method - no implementation
	public abstract void unlockDoor();
	
	
}
