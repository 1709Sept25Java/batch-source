package com.revature.main;

import java.sql.Connection;
import java.util.List;

import com.revature.dao.*;
import com.revature.domain.Bear;
import com.revature.util.*;
public class Driver {

	public static void main(String[] args) {
		/*
		Connection con = null;
		
		try {
			//con = ConnectionUtil.getConnection(url),username,password);
			con = ConnectionUtil.getConnectionFromFile();
			//System.out.println(con.getMetaData().getDriverName());
		} catch(Exception e) {
			e.printStackTrace();
		}
*/
		/*
		BeehiveDao bhd = new BeehiveDaoImpl();
		System.out.println(bhd.getBeeHives().toString());
		System.out.println(bhd.getBeehivebyId(47).toString());
		System.out.println(bhd.updateBeehiveWeight(47, -130));
		System.out.println(bhd.getBeehivebyId(47).toString());
		*/
		CaveDao cd = new CaveDaoImpl();
		System.out.println(cd.getCaves().toString());
		//System.out.println(cd.getCaveById(45).toString());
		
		/*BearTypeDao btd = new BearTypeDaoImpl();
		System.out.println(btd.getBearType().toString());
		System.out.println(btd.getBearTypeById(2).toString());
		
		*/
		BearDao bd = new BearDaoImpl();

		List<Bear> bearList = bd.getBears();

		/*for (Bear b : bearList){

			System.out.println(b.toString());

		}*/

		bd.feedBear(13,5,5);
	}

}
