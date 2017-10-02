package com.revature.building;

public class Driver {

	public static void main(String[] args) { //throws ImpossibleRoomException {
		ThisRoom tr = new ThisRoom(30.0,50.0,RoomType.CLASSROOM);
		tr.openDoor();
		tr.unlockedDoor();
		tr.calculateArea();
		tr.calculatePerimeter();
		System.out.println("area of this room" + tr.calculateArea());
		System.out.println("perimeter of this room " +tr.calculatePerimeter());
		System.out.println(tr);
		System.out.println("This room is a " +tr.type+ "and it is "+tr.type.getDetails());
		
		//iterate through the enum
		System.out.println("the types of rooms are: ");
		for(RoomType rt: RoomType.values()) {
			System.out.println(rt+ rt.getDetails());
		}
		/*try {
			tr.setSide1(60.0);
		}catch (ImpossibleRoomException e) {
			e.printStackTrace();
		}
		try {
			tr.setSide2(5.0);
			System.out.println("Oh look, we moved on");

		}catch (ImpossibleRoomException e) {
			e.printStackTrace();
		}*/

		
	}
}
