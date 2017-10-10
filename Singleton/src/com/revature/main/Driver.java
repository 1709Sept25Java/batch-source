package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Driver {

	public static void main(String[] args) {
		SingleObject obj = SingleObject.getInstance();
		obj.counting();	
		try {
			obj.establishedConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
