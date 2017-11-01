package com.revature.domain;

import java.util.Date;

public class Reimbursements {
	
	private int uidauthor, amnt, uidauth, rttype, rtstatus;
	public Reimbursements(int uidauthor) {
		super();
		this.uidauthor = uidauthor;
	}

	private String disc, reciept;
	private Date rsub, rres;
	
	
	
	public int getUidauthor() {
		return uidauthor;
	}
	public void setUidauthor(int uidauthor) {
		this.uidauthor = uidauthor;
	}
	public int getamnt() {
		return amnt;
	}
	public void setamnt(int amnt) {
		this.amnt = amnt;
	}
	public int getUidauth() {
		return uidauth;
	}
	public void setUidauth(int uidauth) {
		this.uidauth = uidauth;
	}
	public int getRttype() {
		return rttype;
	}
	public void setRttype(int rttype) {
		this.rttype = rttype;
	}
	public int getRtstatus() {
		return rtstatus;
	}
	public void setRtstatus(int rtstatus) {
		this.rtstatus = rtstatus;
	}
	public String getDisc() {
		return disc;
	}
	public void setDisc(String disc) {
		this.disc = disc;
	}
	public String getReciept() {
		return reciept;
	}
	public void setReciept(String reciept) {
		this.reciept = reciept;
	}
	public Date getRsub() {
		return rsub;
	}
	public void setRsub(Date rsub) {
		this.rsub = rsub;
	}
	public Date getRres() {
		return rres;
	}
	public void setRres(Date rres) {
		this.rres = rres;
	}
	public Reimbursements(int uidauthor, int amnt, int uidauth, int rttype, int rtstatus, String disc, String reciept,
			Date rsub, Date rres) {
		super();
		this.uidauthor = uidauthor;
		this.amnt = amnt;
		this.uidauth = uidauth;
		this.rttype = rttype;
		this.rtstatus = rtstatus;
		this.disc = disc;
		this.reciept = reciept;
		this.rsub = rsub;
		this.rres = rres;
	}
	@Override
	public String toString() {
		return "Reimbursements [uidauthor=" + uidauthor + ", amnt=" + amnt + ", uidauth=" + uidauth + ", rttype="
				+ rttype + ", rtstatus=" + rtstatus + ", disc=" + disc + ", reciept=" + reciept + ", rsub=" + rsub
				+ ", rres=" + rres + "]";
	}
	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
}