package ers.domain;

public class UserRoles {

	private int ur_id;
	private String role;
	
	public UserRoles() {
		super();
	}

	public UserRoles(int ur_id, String role) {
		super();
		this.ur_id = ur_id;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoles [ur_id=" + ur_id + ", role=" + role + "]";
	}

	public int getUr_id() {
		return ur_id;
	}

	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
}
