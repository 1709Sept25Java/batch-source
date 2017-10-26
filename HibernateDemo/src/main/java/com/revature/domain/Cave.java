package com.revature.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CAVE")
public class Cave implements Serializable {
	
	public Cave(String name, int maxBears) {
		super();
		this.name = name;
		this.maxBears = maxBears;
	}
	public Cave(int id, String name, int maxBears) {
		super();
		this.id = id;
		this.name = name;
		this.maxBears = maxBears;
	}
	public Cave() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="caveSequence")
	@SequenceGenerator(allocationSize=1,name="caveSequence",sequenceName="SQ_CAVE_PK")
	@Column(name="CAVE_ID")
	private int id;
	@Column(name="CAVE_NAME")
	private String name;
	@Column(name="MAX_BEARS")
	private int maxBears;
	
	@OneToMany(mappedBy="cave",fetch=FetchType.LAZY)
	private List<Bat> bats;
	
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
	public int getMaxBears() {
		return maxBears;
	}
	public void setMaxBears(int maxBears) {
		this.maxBears = maxBears;
	}
	@Override
	public String toString() {
		return "Cave [id=" + id + ", name=" + name + ", maxBears=" + maxBears + "]";
	}
	public List<Bat> getBats() {
		return bats;
	}

}
