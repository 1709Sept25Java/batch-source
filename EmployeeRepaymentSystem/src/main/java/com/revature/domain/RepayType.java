package com.revature.domain;

public class RepayType {

	public RepayType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public RepayType() {
		super();
	}

	private int id;
	
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "RepayType [id=" + id + ", type=" + type + "]";
	}
	
}
