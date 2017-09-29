package com.revature.building;

public class Driver {

	public static void main(String[] args) {
		ThisRoom tr= new ThisRoom(30.0,50.0,RoomType.CLASSROOM);
		/*
		tr.openDoor();
		tr.unlockDoor();
		tr.openDoor();
		System.out.println("area of this room : "+tr.calculateArea());
		System.out.println("Perimeter: "+tr.calculatePerimeter());
		System.out.println(tr);
		
		//iterate through enum
		for(RoomType rt : RoomType.values()) {
			System.out.println(rt+", which is"+ rt.getDetails());
		}
		*/
		
		try {
			tr.setSide1(0.0);
		} catch (ImpossibleRoomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tr.setSide2(5.0);
			System.out.println("We moved on :)");
		} catch (ImpossibleRoomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
