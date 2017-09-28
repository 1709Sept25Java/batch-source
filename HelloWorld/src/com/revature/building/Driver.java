package com.revature.building;

public class Driver {

	public static void main(String[] args) {
		ThisRoom tr = new ThisRoom(30.0, 50.0, RoomType.CLASSROOM);
		/*
		 * tr.openDoor(); tr.unlockDoor(); tr.openDoor();
		 * System.out.println("area of this room: "+tr.calculateArea());
		 * System.out.println("perimeter of this room: "+tr.calculatePerimeter()
		 * ); System.out.println(tr);
		 * System.out.println("this room is a "+tr.type+" and it is "+tr.type.
		 * getDetails());
		 * 
		 * //iterate through the enum
		 * System.out.println("the types of rooms are: "); for (RoomType rt :
		 * RoomType.values()){
		 * System.out.println(rt+", which is "+rt.getDetails()); }
		 */
		try {
			tr.setSide1(0.0);
		} catch (ImpossibleRoomException e) {
			e.printStackTrace();
		}
		try {
			tr.setSide2(5.0);
			System.out.println("Oh look, we moved on");
		} catch (ImpossibleRoomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
