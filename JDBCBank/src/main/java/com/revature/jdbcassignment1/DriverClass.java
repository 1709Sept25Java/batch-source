package com.revature.jdbcassignment1;

import java.sql.SQLException;

public class DriverClass {

	public static void main(String[] args) {

		//SuperUser sUser = new SuperUser();
		//sUser.superUserFunction();

		/*try { UserOperation.regiterNewUser(); 
		} catch (SQLException e) {
				  
				  e.printStackTrace(); 
		}*/


		 Login log = new Login();
		 log.execute();
		 UserOperation.perform();
	}
}
