package com.revature.building;

public enum RoomType {
	
	CLASSROOM("where we learn"),
	CONFERENCE_ROOM("where we work"),
	BEDROOM("where we sleep"),
	BATHROOM("where we wash"),
	KITCHEN("where we wash");

	private String details;
	
	RoomType(String details){
		this.details=details;
	}
	
	String getDetails() {
		return this.details;
	}	
	
}
