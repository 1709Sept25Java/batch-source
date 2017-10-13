package com.revature.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bear {
	
	public Bear(String name, Cave cave, BearType bearType, int weight, Date birthdate) {
		super();
		this.name = name;
		this.cave = cave;
		this.bearType = bearType;
		this.weight = weight;
		this.birthdate = birthdate;
	}
	public Bear(int id, String name, Cave cave, BearType bearType, int weight, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.cave = cave;
		this.bearType = bearType;
		this.weight = weight;
		this.birthdate = birthdate;
	}
	public Bear() {
		super();
	}
	private int id;
	private String name;
	private Cave cave;
	private BearType bearType;
	private int weight;
	private Date birthdate;
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public Cave getCave() {
		return cave;
	}
	public void setCave(Cave cave) {
		this.cave = cave;
	}
	
	@XmlElement
	public BearType getBearType() {
		return bearType;
	}
	public void setBearType(BearType bearType) {
		this.bearType = bearType;
	}
	
	@XmlElement
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@XmlElement
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", cave=" + cave + ", bearType=" + bearType + ", weight=" + weight
				+ ", birthdate=" + birthdate + "]";
	}

}
