package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

import com.revature.dao.*;
import com.revature.domain.Bear;
import com.revature.domain.BearType;

public class Driver {

	public static void main(String[] args) {
//		Connection con = null;
//		try {
//			con = ConnectionUtil.getConnectionFromFile();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}	
		try {
			Connection con = ConnectionUtil.getConnectionFromFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		BeehiveDao bhd = new BeehiveDaoImpl();
//		System.out.println(bhd.getBeehives().toString());
//		System.out.println(bhd.getBeehiveById(7).toString());
//		System.out.println(bhd.updateBeehiveWeight(7, -130));
//		System.out.println(bhd.getBeehiveById(7).toString());

//		CaveDao cd = new CaveDaoImpl();
//		System.out.println(cd.getCaves().toString());
//		System.out.println(cd.getCaveById(5));
		
		//Bounding is internet speed + pinging database with connections
//		BearTypeDao bt = new BearTypeImpl();
//		System.out.println(bt.getBearTypes());
//		System.out.println(bt.getBearTypeById(3));
		
		Bear b = new Bear("Joe", new Cave(7,"Manhattan",10), new BearType(1,"Grizzly"),500, new Date(1992,9,5));
	}
}
