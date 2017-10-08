package com.revature.domain;

public class BearType {
	
	public BearType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public BearType(String name) {
		super();
		//don't specify id because we don't generate it's sequencing
		this.name = name;
	}
	public BearType() {
		super();
	}
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setWeight(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BearType [id=" + id + ", name=" + name + "]";
	}
}
