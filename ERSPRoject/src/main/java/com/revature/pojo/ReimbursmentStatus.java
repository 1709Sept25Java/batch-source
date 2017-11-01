package com.revature.pojo;

public class ReimbursmentStatus {

	public ReimbursmentStatus() {
		super();
	}

	@Override
	public String toString() {
		return "ReimbursmentStatus [rs_status=" + rs_status + ", rt_statusId=" + rt_statusId + "]";
	}

	public String getRs_status() {
		return rs_status;
	}

	public void setRs_status(String rs_status) {
		this.rs_status = rs_status;
	}

	public int getRt_statusId() {
		return rt_statusId;
	}

	public void setRt_statusId(int rt_statusId) {
		this.rt_statusId = rt_statusId;
	}

	public ReimbursmentStatus(String rs_status, int rt_statusId) {
		super();
		this.rs_status = rs_status;
		this.rt_statusId = rt_statusId;
	}

	public String rs_status;
	public int rt_statusId;
}
