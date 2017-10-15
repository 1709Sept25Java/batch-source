package bank.domain;

public class UserType {

	private int userTypeId;
	private String userTypeName;
	
	public UserType() {
		super();
	}

	public UserType(int userTypeId, String userTypeName) {
		super();
		this.userTypeId = userTypeId;
		this.userTypeName = userTypeName;
	}

	@Override
	public String toString() {
		return "UserType [userTypeId=" + userTypeId + ", userTypeName=" + userTypeName + "]";
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	
	
	
	
}
