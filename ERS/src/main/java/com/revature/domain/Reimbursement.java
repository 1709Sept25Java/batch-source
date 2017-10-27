package com.revature.domain;
import java.sql.Blob;
import java.util.Date;

public class Reimbursement {
	private int rID;
	private int rAmount;
	private String rDescription;
	private Blob rReceipt;  //ATTENTION HERE! BLOB?
	private Date rSubmitted;
	private Date rResolved;
	private int uIDAuthor;
	private int uIDResolver;
	private int rtType;
	private int rtStatus;
	
	public Reimbursement() {
		super();
	}
	
	//Constructor of required fields (not null on database)
	public Reimbursement(int rID, int rAmount, Date rSubmitted, int uIDAuthor, int rtType, int rtStatus) {
		super();
		this.rID = rID;
		this.rAmount = rAmount;
		this.uIDAuthor = uIDAuthor;
		this.rSubmitted = rSubmitted;
		this.rtType = rtType;
		this.rtStatus = rtStatus;
	}

	public Reimbursement(int rID, int rAmount, String rDescription, Blob rReceipt, Date rSubmitted, Date rResolved,
			int uIDAuthor, int uIDResolver, int rtType, int rtStatus) {
		super();
		this.rID = rID;
		this.rAmount = rAmount;
		this.rDescription = rDescription;
		this.rReceipt = rReceipt;
		this.rSubmitted = rSubmitted;
		this.rResolved = rResolved;
		this.uIDAuthor = uIDAuthor;
		this.uIDResolver = uIDResolver;
		this.rtType = rtType;
		this.rtStatus = rtStatus;
	}
	
	public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public int getrAmount() {
		return rAmount;
	}

	public void setrAmount(int rAmount) {
		this.rAmount = rAmount;
	}

	public String getrDescription() {
		return rDescription;
	}

	public void setrDescription(String rDescription) {
		this.rDescription = rDescription;
	}

	public Blob getrReceipt() {
		return rReceipt;
	}

	public void setrReceipt(Blob rReceipt) {
		this.rReceipt = rReceipt;
	}

	public Date getrSubmitted() {
		return rSubmitted;
	}

	public void setrSubmitted(Date rSubmitted) {
		this.rSubmitted = rSubmitted;
	}

	public Date getrResolved() {
		return rResolved;
	}

	public void setrResolved(Date rResolved) {
		this.rResolved = rResolved;
	}

	public int getuIDAuthor() {
		return uIDAuthor;
	}

	public void setuIDAuthor(int uIDAuthor) {
		this.uIDAuthor = uIDAuthor;
	}

	public int getuIDResolver() {
		return uIDResolver;
	}

	public void setuIDResolver(int uIDResolver) {
		this.uIDResolver = uIDResolver;
	}

	public int getRtType() {
		return rtType;
	}

	public void setRtType(int rtType) {
		this.rtType = rtType;
	}

	public int getRtStatus() {
		return rtStatus;
	}

	public void setRtStatus(int rtStatus) {
		this.rtStatus = rtStatus;
	}

	@Override
	public String toString() {
		return "Reimbursement [rID=" + rID + ", rAmount=" + rAmount + ", rDescription=" + rDescription + ", rReceipt="
				+ rReceipt + ", rSubmitted=" + rSubmitted + ", rResolved=" + rResolved + ", uIDAuthor=" + uIDAuthor
				+ ", uIDResolver=" + uIDResolver + ", rtType=" + rtType + ", rtStatus=" + rtStatus + "]";
	}


}
