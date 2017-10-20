package ers.domain;

public class Status {

	private int rs_id;
	private String status;
	
	public Status() {
		super();
	}

	public Status(int rs_id, String status) {
		super();
		this.rs_id = rs_id;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Status [rs_id=" + rs_id + ", status=" + status + "]";
	}

	public int getRs_id() {
		return rs_id;
	}

	public void setRs_id(int rs_id) {
		this.rs_id = rs_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
