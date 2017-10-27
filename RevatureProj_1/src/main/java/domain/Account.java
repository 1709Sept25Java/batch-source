package domain;

public class Account {
	public Account() {
		super();
	}

	private String reinbursement_user;
	private String reinbursement_type;
	private String reinbursement_status;
	private String reinbursement_amount;
	private String reinbursement_img;
	
	public Account(String reinbursement_user,String reinbursement_type, 
			String reinbursement_status, String reinbursement_amount, String reinbursement_img){
		super();
		this.reinbursement_user=reinbursement_user;
		this.reinbursement_type=reinbursement_type;
		this.reinbursement_amount=reinbursement_amount;
		this.reinbursement_img=reinbursement_img; 	
	}
	
	public String getReinbursement_user() {
		return reinbursement_user;
	}
	public void setReinbursement_user(String reinbursement_user) {
		this.reinbursement_user = reinbursement_user;
	}

	public String getReinbursement_type() {
		return reinbursement_type;
	}

	public void setReinbursement_type(String reinbursement_type) {
		this.reinbursement_type = reinbursement_type;
	}

	public String getReinbursement_status() {
		return reinbursement_status;
	}

	public void setReinbursement_status(String reinbursement_status) {
		this.reinbursement_status = reinbursement_status;
	}

	public String getReinbursement_amount() {
		return reinbursement_amount;
	}

	public void setReinbursement_amount(String reinbursement_amount) {
		this.reinbursement_amount = reinbursement_amount;
	}

	public String getReinbursement_img() {
		return reinbursement_img;
	}

	public void setReinbursement_img(String reinbursement_img) {
		this.reinbursement_img = reinbursement_img;
	}
}
