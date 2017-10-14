package com.revature.domain;

import java.sql.Date;

public class UserHist {

	public UserHist(Date logDate, String type, Users owner, int owned) {
		super();
		this.type = type;
		this.logDate = logDate;
		this.owner = owner;
		this.owned = owned;
	}

	public UserHist() {
		super();
	}

	private int id;
	
	private String type;
	
	private Date logDate;
	
	private Users owner;
	
	private int owned;

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

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
	}

	public int getOwned() {
		return owned;
	}

	public void setOwned(int owned) {
		this.owned = owned;
	}

	@Override
	public String toString() {
		return "UserHist [type=" + type + ", logDate=" + logDate + ", owner=" + owner + ", owned=" + owned + "]";
	}
}
