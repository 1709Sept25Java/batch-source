package com.jdbc.main;
import java.sql.Date;
import java.sql.Connection;
import com.jdbcbank.util.ConnectionUtil;
public class Driver {
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile(connection.properties);
			System.out.println(con.getMetaData().getDriverName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
