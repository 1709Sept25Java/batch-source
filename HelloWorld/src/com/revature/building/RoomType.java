package com.revature.building;

public enum RoomType {
	
	CLASSROOM("where we learn"),
	CONFERENCE_ROOM("where we talk"),
	OFFICE("I don't have one at present"),
	BEDROOM("where we sleep"),
	BATHROOM("where we wash"),
	KITCHEN("where we cook");
	
	private String details;
	
	RoomType(String details) {
		this.details = details;
	}
	
	public String getDetails(){
		return details;
	}
	
	
	
}