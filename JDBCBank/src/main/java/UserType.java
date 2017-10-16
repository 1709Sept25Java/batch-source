
public class UserType {

	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserType(String userTpye) {
		super();
		this.userTpye = userTpye;
	}
	public UserType(int userTypeId, String userTpye) {
		super();
		this.userTypeId = userTypeId;
		this.userTpye = userTpye;
	}
	private int userTypeId;
	private String userTpye;
	
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserTpye() {
		return userTpye;
	}
	public void setUserTpye(String userTpye) {
		userTpye = userTpye;
	}
	@Override
	public String toString() {
		return "UserType [userTypeId=" + userTypeId + ", UserTpye=" + userTpye + "]";
	}
}
