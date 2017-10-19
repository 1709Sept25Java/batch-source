package com.revature.domain;

public class ReimbursementType {
	private int rtID;
	private String rtType;
	public ReimbursementType() {
		super();
	}
	public ReimbursementType(int id, String type) {
		super();
		this.rtID = id;
		this.rtType = type;
	}
	public int getRtID() {
		return rtID;
	}
	public void setRtID(int rtID) {
		this.rtID = rtID;
	}
	public String getRtType() {
		return rtType;
	}
	public void setRtType(String rtType) {
		this.rtType = rtType;
	}
	@Override
	public String toString() {
		return "ReimbursementType [rtID=" + rtID + ", rtType=" + rtType + "]";
	}

}
