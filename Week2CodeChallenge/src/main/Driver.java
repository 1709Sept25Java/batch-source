package main;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import dao.*;
import domain.*;
import util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile();
			//.out.println(con.getMetaData().getDriverName());
		} catch(Exception e){
			e.printStackTrace();
		}

	}

}