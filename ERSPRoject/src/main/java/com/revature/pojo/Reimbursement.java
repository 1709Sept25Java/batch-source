package com.revature.pojo;

import java.sql.Blob;
import java.sql.Timestamp;
import oracle.sql.BLOB;

public class Reimbursement {

	private int rt_id;
	private double amount;
	private String description;
	private Blob reciept;
	private Timestamp submitDate;
	private Timestamp resolvedDate;
	private User authorId;
	private User resolverId;
	private Reimbursmentype rt_typeId;
	private ReimbursmentStatus rt_statusId;

	public Reimbursement() {
		super();

	}

	@Override
	public String toString() {
		return "Reimbursement [rt_id=" + rt_id + ", amount=" + amount + ", description=" + description + ", submitDate="
				+ submitDate + ", resolvedDate=" + resolvedDate + ", authorId=" + authorId + ", resolverId="
				+ resolverId + ", rt_typeId=" + rt_typeId + ", rt_statusId=" + rt_statusId + ", reciept =" + reciept + "]";
	}

	public int getRt_id() {
		return rt_id;
	}

	public void setRt_id(int rt_id) {
		this.rt_id = rt_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Timestamp submitDate) {
		this.submitDate = submitDate;
	}

	public Timestamp getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Timestamp resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public User getAuthorId() {
		return authorId;
	}

	public void setAuthorId(User authorId) {
		this.authorId = authorId;
	}

	public User getResolverId() {
		return resolverId;
	}

	public void setResolverId(User resolverId) {
		this.resolverId = resolverId;
	}

	public Reimbursmentype getRt_typeId() {
		return rt_typeId;
	}

	public void setRt_typeId(Reimbursmentype rt_typeId) {
		this.rt_typeId = rt_typeId;
	}

	public ReimbursmentStatus getRt_statusId() {
		return rt_statusId;
	}

	public void setRt_statusId(ReimbursmentStatus rt_statusId) {
		this.rt_statusId = rt_statusId;
	}

	public Reimbursement(int rt_id, double amount, String description, Blob reciept, Timestamp submitDate, Timestamp resolvedDate,
			User authorId, User resolverId, Reimbursmentype rt_typeId, ReimbursmentStatus rt_statusId) {
		super();
		this.rt_id = rt_id;
		this.amount = amount;
		this.description = description;
		this.reciept = reciept;
		this.submitDate = submitDate;
		this.resolvedDate = resolvedDate;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.rt_typeId = rt_typeId;
		this.rt_statusId = rt_statusId;
		
	}

	public Blob getReciept() {
		return reciept;
	}

	public void setReciept(BLOB reciept) {
		this.reciept = reciept;
	}

}
