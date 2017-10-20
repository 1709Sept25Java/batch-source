package ers.domain;

import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursements {

	private int r_id;
	private double amount;
	private String description;
	private Blob receipt;
	private Timestamp submitted; 
	private Timestamp resolved; 
	private int id_author;
	private int id_resolver;
	private int type;
	private int status;
	
	public Reimbursements() {
		super();
	}

	public Reimbursements(int r_id, double amount, String description, Blob receipt, Timestamp submitted,
			Timestamp resolved, int id_author, int id_resolver, int type, int status) {
		super();
		this.r_id = r_id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.id_author = id_author;
		this.id_resolver = id_resolver;
		this.type = type;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursements [r_id=" + r_id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", id_author=" + id_author
				+ ", id_resolver=" + id_resolver + ", type=" + type + ", status=" + status + "]";
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
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

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public int getId_author() {
		return id_author;
	}

	public void setId_author(int id_author) {
		this.id_author = id_author;
	}

	public int getId_resolver() {
		return id_resolver;
	}

	public void setId_resolver(int id_resolver) {
		this.id_resolver = id_resolver;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
