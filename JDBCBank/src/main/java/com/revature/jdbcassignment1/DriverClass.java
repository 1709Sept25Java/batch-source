package com.revature.jdbcassignment1;

import java.sql.SQLException;

public class DriverClass {

	public static void main(String[] args) {

		/* Login log = new Login();
		 log.execute();
		  UserOperation.perform();
		try {
			UserOperation.regiterNewUser();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		*/
		
		SuperUser sUser = new SuperUser();
		sUser.superUserFunction();
		
	}
}
