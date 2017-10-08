package com.revature.main;

import java.sql.Connection;
import java.sql.Date;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		Connection con=null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			//System.out.println(con.getMetaData().getDriverName());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		BeehiveDao bhd = new BeehiveDaoImpl();
		System.out.println(bhd.getBeehives().toString());
		System.out.println(bhd.getBeehiveById(7).toString());
		//System.out.println(bhd.updateBeehiveWeight(7, -130));
		System.out.println(bhd.getBeehiveById(7).toString());
		
		BearDao bd = new BearDaoImpl();
		
		Bear b = new Bear("Joe",new Cave(7,"MANHATTAN",10),new BearType(1,"Grizzly"),200,new Date(1992,9,5));
		
		System.out.println(bd.createBear(b));
	}
	
}
