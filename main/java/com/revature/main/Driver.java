package com.revature.main;


import com.revature.dao.SuperUserDaoImpl;
import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class Driver {

	public static void main(String[] args) throws SQLException, IOException {

		//LoginDaoImpl.Welcome();
		
		Connection con = ConnectionUtil.getAdminConnection();
		SuperUserDaoImpl.updateUser(con);

	}

}
