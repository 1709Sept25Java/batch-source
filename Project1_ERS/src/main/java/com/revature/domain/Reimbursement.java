package com.revature.domain;

import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {

	public Reimbursement() {
		super();
	}
	
	private int rid;
	private float amt;
	private String descr;
	private Date submitDate;
	private String author;

	
	public Reimbursement(int rid,float amt,String descr,Date submitDate,String author) {
		this.rid = rid;
		this.amt = amt;
		this.descr = descr;
		this.submitDate = submitDate;
		this.author = author;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) { //do I want this to be public, private, or default? what classes do I want to be able to set the R_ID?
		this.rid = rid;
	}

	public float getAmt() {
		return amt;
	}

	public void setAmt(float amt) {
		this.amt = amt;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
	@Override
	public String toString() {
		return "Reimbursement [rid=" + rid + ", amt=" + amt + ", descr=" + descr + ", submitDate=" + submitDate
				+ ", author=" + author + "]";
	}


}
