package com.revature.domain;

public class Reimbursement {
	
	private int reimbId;
	private int amount;
	private String description;
	//receipt
	private String receiptUrl;
	private String status;
	private String timeSubmitted;
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", description=" + description
				+ ", receiptUrl=" + receiptUrl + ", status=" + status + ", timeSubmitted=" + timeSubmitted
				+ ", timeResolved=" + timeResolved + ", authorId=" + authorId + ", resolverId=" + resolverId + "]";
	}

	public String getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}

	private String timeResolved;
	private int authorId;
	private int resolverId;
	
	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, int amount, String description, String receiptUrl, String status, String timeSubmitted, String timeResolved,
			int authorId, int resolverId) {
		super();
		this.reimbId = id;
		this.amount = amount;
		this.description = description;
		this.receiptUrl = receiptUrl;
		this.status = status;
		this.timeSubmitted = timeSubmitted;
		this.timeResolved = timeResolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
	}

	public int getReimbId() {
		return reimbId;
	}

	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReceiptUrl() {
		return receiptUrl;
	}

	public void setReceiptUrl(String receiptUrl) {
		this.receiptUrl = receiptUrl;
	}

	public String getTimeResolved() {
		return timeResolved;
	}

	public void setTimeResolved(String timeResolved) {
		this.timeResolved = timeResolved;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
