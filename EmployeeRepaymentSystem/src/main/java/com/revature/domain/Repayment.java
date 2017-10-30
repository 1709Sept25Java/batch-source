package com.revature.domain;

import java.sql.Blob;
import java.sql.Timestamp;

public class Repayment {
	
	public Repayment(int id, double amount, Timestamp sumbitted, String empName, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.sumbitted = sumbitted;
		this.empName = empName;
		this.status = status;
		this.type = type;
	}

	public Repayment(int id, double amount, String summary, Blob receipt, Timestamp sumbitted, Timestamp resolved,
			int emp, int mgr, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.summary = summary;
		this.receipt = receipt;
		this.sumbitted = sumbitted;
		this.resolved = resolved;
		this.emp = emp;
		this.mgr = mgr;
		this.status = status;
		this.type = type;
	}

	public Repayment(int id, double amount, Timestamp sumbitted, int emp, String status, String type) {
		super();
		this.id = id;
		this.amount = amount;
		this.sumbitted = sumbitted;
		this.emp = emp;
		this.status = status;
		this.type = type;
	}

	public Repayment() {
		super();
	}

	private int id;
	
	private double amount;
	
	private String summary;
	
	private Blob receipt;
	
	private Timestamp sumbitted;
	
	private Timestamp resolved;
	
	private int emp;
	
	private String empName;
	
	private int mgr;
	
	private String mgrName;
	
	private String status;
	
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSumbitted() {
		return sumbitted;
	}

	public void setSumbitted(Timestamp sumbitted) {
		this.sumbitted = sumbitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getEmp() {
		return emp;
	}

	public void setEmp(int emp) {
		this.emp = emp;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Repayment [id=" + id + ", amount=" + amount + ", summary=" + summary + ", receipt=" + receipt
				+ ", sumbitted=" + sumbitted + ", resolved=" + resolved + ", emp=" + emp + ", empName=" + empName
				+ ", mgr=" + mgr + ", mgrName=" + mgrName + ", status=" + status + ", type=" + type + "]";
	}
}
