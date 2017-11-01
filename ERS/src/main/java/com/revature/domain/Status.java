package com.revature.domain;

public class Status {
	int rsid;
	String rsstatus;
	public int getRsid() {
		return rsid;
	}
	public void setRsid(int rsid) {
		this.rsid = rsid;
	}
	public String getRsstatus() {
		return rsstatus;
	}
	public void setRsstatus(String rsstatus) {
		this.rsstatus = rsstatus;
	}
	@Override
	public String toString() {
		return "Status [rsid=" + rsid + ", rsstatus=" + rsstatus + "]";
	}
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status(int rsid, String rsstatus) {
		super();
		this.rsid = rsid;
		this.rsstatus = rsstatus;
	}
	
	
	
}
