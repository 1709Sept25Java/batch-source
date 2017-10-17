package com.revature.main;

import java.io.IOException;
import java.sql.SQLException;
import com.revature.dao.LoginDaoImpl;

public class Driver {

	public static void main(String[] args) throws SQLException, IOException {

		LoginDaoImpl.Welcome();
	
	}

}
