package com.revature.main;
import java.sql.Connection;
import com.revature.util.ConnectionUtil;

public class Driver {
		
public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			} catch(Exception e){
			e.printStackTrace();
		}
	}
}