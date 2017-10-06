package com.revature.main;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.revature.dao.*;
import com.revature.domain.Bear;
import com.revature.domain.BearType;
import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		/*
		Connection con = null;
		
		try {
			con = ConnectionUtil.getConnectionFromFile();
			//.out.println(con.getMetaData().getDriverName());
		} catch(Exception e){
			e.printStackTrace();
		}
		*/
		/*
		BeehiveDao bhd = new BeehiveDaoImpl();
		System.out.println(bhd.getBeehives().toString());
		System.out.println(bhd.getBeehiveById(7).toString());
		System.out.println(bhd.updateBeehiveWeight(7, -130));
		System.out.println(bhd.getBeehiveById(7).toString());
		
		
		CaveDao cd = new CaveDaoImpl();
		System.out.println(cd.getCaves().toString());
		System.out.println(cd.getCaveById(5).toString());
		
		BearTypeDao btd = new BearTypeDaoImpl();
		System.out.println(btd.getBearTypes().toString());
		System.out.println(btd.getBearTypeById(2).toString());
		*/
		
		BearDao bd = new BearDaoImpl();
		List<Bear> bearList = bd.getBears();
		for (Bear b : bearList){
			System.out.println(b.toString());
		}
		/*
		bd.feedBear(13,5,5);
		
		System.out.println(bd.getBearById(13));
		
		Bear b = new Bear("Joe",new Cave(7,"Manhattan",10),new BearType(1,"Grizzly"),200,new Date(1992,9,5));
		
		System.out.println(bd.createBear(b));*/
		
		
		

	}

}
