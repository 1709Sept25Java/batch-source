package com.revature.domain;

public class ReimbursementStatus {

	private int rsID;
	private String rsStatus;
	public ReimbursementStatus() {
		super();
	}
	public ReimbursementStatus(int id, String status) {
		super();
		this.rsID = id;
		this.rsStatus = status;
	}
	public int getRsID() {
		return rsID;
	}
	public void setRsID(int rsID) {
		this.rsID = rsID;
	}
	public String getRsStatus() {
		return rsStatus;
	}
	public void setRsStatus(String rsStatus) {
		this.rsStatus = rsStatus;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [rsID=" + rsID + ", rsStatus=" + rsStatus + "]";
	}
}
