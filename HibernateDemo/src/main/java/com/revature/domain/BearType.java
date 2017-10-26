package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="BEAR_TYPE")
public class BearType implements Serializable{
	
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bearTypeSequence")
	@SequenceGenerator(allocationSize=1,name="bearTypeSequence",sequenceName="SQ_BEAR_TYPE_PK")
	@Column(name="BEAR_TYPE_ID")
	private int id;
	
	@Column(name="BEAR_TYPE_NAME")
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
