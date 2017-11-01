package com.revature.domain;

public class Type {
	
	int rtid;
	String rttype;
	public int getRtid() {
		return rtid;
	}
	public void setRtid(int rtid) {
		this.rtid = rtid;
	}
	public String getRttype() {
		return rttype;
	}
	public void setRttype(String rttype) {
		this.rttype = rttype;
	}
	@Override
	public String toString() {
		return "Type [rtid=" + rtid + ", rttype=" + rttype + "]";
	}
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
