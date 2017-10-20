package com.revature.domain;

import java.sql.Blob;
import java.sql.Timestamp;

public class Repayment {

	public Repayment(int id, double amount, String summary, Blob receipt, Timestamp sumbitted, Timestamp resolved,
			Employee emp, Employee mgr, RepayStatus status, RepayType type) {
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

	public Repayment() {
		super();
	}

	private int id;
	
	private double amount;
	
	private String summary;
	
	private Blob receipt;
	
	private Timestamp sumbitted;
	
	private Timestamp resolved;
	
	private Employee emp;
	
	private Employee mgr;
	
	private RepayStatus status;
	
	private RepayType type;

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

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Employee getMgr() {
		return mgr;
	}

	public void setMgr(Employee mgr) {
		this.mgr = mgr;
	}

	public RepayStatus getStatus() {
		return status;
	}

	public void setStatus(RepayStatus status) {
		this.status = status;
	}

	public RepayType getType() {
		return type;
	}

	public void setType(RepayType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Repayment [id=" + id + ", amount=" + amount + ", summary=" + summary
				+ ", sumbitted=" + sumbitted + ", resolved=" + resolved + ", emp=" + emp.getlName() + ", mgr=" 
				+ mgr.getlName() + ", status=" + status.getStatus() + ", type=" + type.getType() + "]";
	}
}
