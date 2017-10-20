package com.revature.domain;

public class RepayStatus {

	public RepayStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public RepayStatus() {
		super();
	}

	private int id;
	
	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RepayStatus [id=" + id + ", status=" + status + "]";
	}
	
}
