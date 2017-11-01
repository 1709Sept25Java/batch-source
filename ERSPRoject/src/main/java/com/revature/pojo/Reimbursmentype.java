package com.revature.pojo;

public class Reimbursmentype {

	public String rt_type;

	public Reimbursmentype() {
		super();
	}

	@Override
	public String toString() {
		return "Reimbursmentype [rt_type=" + rt_type + ", rt_typeId=" + rt_typeId + "]";
	}

	public String getRt_type() {
		return rt_type;
	}

	public void setRt_type(String rt_type) {
		this.rt_type = rt_type;
	}

	public int getRt_typeId() {
		return rt_typeId;
	}

	public void setRt_typeId(int rt_typeId) {
		this.rt_typeId = rt_typeId;
	}

	public Reimbursmentype(String rt_type, int rt_typeId) {
		super();
		this.rt_type = rt_type;
		this.rt_typeId = rt_typeId;
	}

	public int rt_typeId;

}
