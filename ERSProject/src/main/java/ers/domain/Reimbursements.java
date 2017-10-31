package ers.domain;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

public class Reimbursements {

	private int r_id;
	private double amount;
	private String description;
	private Blob receipt;
	private String submitted; 
	private String resolved; 
	private int id_author;
	private int id_resolver;
	private int type;
	private int status;
	private String author;
	private String resolver;
	private String type1;
	private String status1;
	private String amount1;
	
	public Reimbursements() {
		super();
	}


		
	public Reimbursements(int r_id, String amount2, String description, Blob receipt, String submitted, String resolved,
			String author, String resolver, String type1, String status1) {
		super();
		this.r_id = r_id;
		this.amount1 = amount2;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type1 = type1;
		this.status1 = status1;
	}



	@Override
	public String toString() {
		return "Reimbursements [r_id=" + r_id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", id_author=" + id_author
				+ ", id_resolver=" + id_resolver + ", type=" + type + ", status=" + status + "]";
	}


	public Reimbursements(int r_id, double amount, String description, Blob receipt, String submitted, String resolved,
			int id_author, int id_resolver, int type, int status) {
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

	
	

	public Reimbursements(int r_id, String description, Blob receipt, String submitted, String resolved, int id_author,
			int id_resolver, int type, int status, String author, String resolver, String type1, String status1,
			String amount1) {
		super();
		this.r_id = r_id;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.id_author = id_author;
		this.id_resolver = id_resolver;
		this.type = type;
		this.status = status;
		this.author = author;
		this.resolver = resolver;
		this.type1 = type1;
		this.status1 = status1;
		this.amount1 = amount1;
	}



	protected int getR_id() {
		return r_id;
	}


	protected void setR_id(int r_id) {
		this.r_id = r_id;
	}


	protected double getAmount() {
		return amount;
	}


	protected void setAmount(double amount) {
		this.amount = amount;
	}


	protected String getDescription() {
		return description;
	}


	protected void setDescription(String description) {
		this.description = description;
	}


	protected Blob getReceipt() {
		return receipt;
	}


	protected void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}


	protected String getSubmitted() {
		return submitted;
	}


	protected void setSubmitted(String submitted) {
		this.submitted = submitted;
	}


	protected String getResolved() {
		return resolved;
	}


	protected void setResolved(String resolved) {
		this.resolved = resolved;
	}


	protected int getId_author() {
		return id_author;
	}


	protected void setId_author(int id_author) {
		this.id_author = id_author;
	}


	protected int getId_resolver() {
		return id_resolver;
	}


	protected void setId_resolver(int id_resolver) {
		this.id_resolver = id_resolver;
	}


	protected int getType() {
		return type;
	}


	protected void setType(int type) {
		this.type = type;
	}


	protected int getStatus() {
		return status;
	}


	protected void setStatus(int status) {
		this.status = status;
	}

	
	
	
	
	
}
