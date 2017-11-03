package com.revature.beans;

import java.util.Date;

import com.revature.beans.Cave;

public class Bear {
	
	private int id;
	private String name;
	private String bearType;
	private int weight;
	private Date birthdate;
	
	private Cave cave;
	
	public Cave getCave(){
		return this.cave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBearType() {
		return bearType;
	}

	public void setBearType(String bearType) {
		this.bearType = bearType;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}
	
}