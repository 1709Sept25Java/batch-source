package com.revature.ers;

import java.sql.SQLException;
import com.revature.ersdao.*;

public class EmpLogin {
	private String userName, userPass;

	public EmpLogin() {
		super();
	}

	public EmpLogin(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public boolean execute (String username, String password) throws SQLException {

		if (EmpLoginDao.validate(username,password)) {
			return true;
		} else
			return false;
	}

	
}
