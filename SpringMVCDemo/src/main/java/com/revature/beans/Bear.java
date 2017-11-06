package com.revature.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bear{

	private Date birthDay;
	private int id;
	private String name;
	private int weight;
	private String bearType;
	
	@Autowired //@Inject is pretty much synonymous
	private Cave cave;
	
	public Cave getCave() {
		return this.cave;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getBearType() {
		return bearType;
	}

	public void setBearType(String bearType) {
		this.bearType = bearType;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "Bear [birthDay=" + birthDay + ", id=" + id + ", name=" + name + ", weight=" + weight + ", bearType="
				+ bearType + ", cave=" + cave + "]";
	}
	
}
