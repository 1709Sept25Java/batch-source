package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BAT")
public class Bat implements Serializable{

	public Bat() {
		super();
	}
	
	/*
	 * public Bat(Cave c){
	 * 	this.cave =c;
	 * }
	 * */
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="batSequence")
	@SequenceGenerator(allocationSize=1,name="batSequence",sequenceName="SQ_BAT_PK")
	@Column(name="BAT_ID")
	private int id;
	
	@Column(name="BAT_NAME")
	private String name;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="CAVE_ID")
	//private Cave cave;

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

	/*
	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}
	*/
	
}
