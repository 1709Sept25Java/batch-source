package dao;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Reimbursements {

	public Reimbursements() {
		super();
	}
	public Reimbursements(int reimId, double amount, String description, Timestamp submitted, Timestamp resolved,
			Users author, Users resolver, ReimbursementType type, ReimbursementStatus status) {
		super();
		this.reimId = reimId;
		this.amount = amount;
		this.description = description;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}
	private int reimId;
	private double amount;
	private String description;
	private Timestamp submitted;
	private Timestamp resolved;
	private Users author;
	private Users resolver;
	private ReimbursementType type;
	private ReimbursementStatus status;
	@XmlAttribute
	public int getReimId() {
		return reimId;
	}
	public void setReimId(int reimId) {
		this.reimId = reimId;
	}
	@XmlElement
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@XmlElement
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	@XmlElement
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	@XmlElement
	public Users getAuthor() {
		return author;
	}
	public void setAuthor(Users author) {
		this.author = author;
	}
	@XmlElement
	public Users getResolver() {
		return resolver;
	}
	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}
	@XmlElement
	public ReimbursementType getType() {
		return type;
	}
	public void setType(ReimbursementType type) {
		this.type = type;
	}
	@XmlElement
	public ReimbursementStatus getStatus() {
		return status;
	}
	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reimbursements [reimId=" + reimId + ", amount=" + amount + ", description=" + description
				+ ", submitted=" + submitted + ", resolved=" + resolved + ", author=" + author + ", resolver="
				+ resolver + ", type=" + type + ", status=" + status + "]";
	}
	
}
