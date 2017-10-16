package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BearType;
import com.revature.domain.Beehive;
import com.revature.util.ConnectionUtil;

public class BearTypeDaoImpl implements BearTypeDao{

	@Override
	public List<BearType> getBearTypes() {
		List<BearType> btl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			//use a Statement - remember the danger of SQL Injection
			String sql = "SELECT * FROM BEAR_TYPE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("BEAR_TYPE_ID");
				String name = rs.getString("BEAR_TYPE_NAME");
				BearType newBt1= new BearType(id,name);
				btl.add(newBt1);
			}
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		return btl;
	}

	@Override
	public BearType getBearTypeById(int id) {
		return null;
	}
	

}
