package com.revature.building;

public enum RoomType {

	
	CLASSROOM("where we learn"),
	CONFERENCE_ROOM("Where we talk"),
	OFFICE("nothing"), 
	BEDROOM("where we sleep"), 
	BATHROOM("where we wash"), 
	KITCHEN("where we cook");
	
	
	private String details;
	RoomType(String details){
		this.details= details;
	}
	public String getDetails() {
		return details;
	}
	
	
}
