package revature.project2hw;

public class User {
	//get username and password, along with id
		public User() {
			super();
		}
		
		private String user;
		private String pw;
		private int userid;
		
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw=pw;
		}
		
		public int getUserId(){
			return userid;
		}
		public void setUserId(int userid) {
			this.userid=userid;
		}
}
