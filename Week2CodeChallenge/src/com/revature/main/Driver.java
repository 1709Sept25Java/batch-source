package com.revature.main;

import java.sql.Connection;

import com.revature.util.ConnectUtil;

public class Driver {

	public static void main(String[] args) {
		Connection con=null;
		try {
			con = ConnectUtil.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
