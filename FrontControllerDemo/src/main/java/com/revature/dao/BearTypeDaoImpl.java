package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BearType;
import com.revature.domain.Cave;
import com.revature.domain.BearType;
import com.revature.util.ConnectionUtil;

public class BearTypeDaoImpl implements BearTypeDao{

	@Override
	public List<BearType> getBearTypes() {
		
		List<BearType> bt1 = new ArrayList<>();
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			
			//Use a Statement-remember the danger of SQL Injection
			String sql = "SELECT * FROM BEAR_TYPE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			//Pulling entries from DB and creating objects
			while(rs.next()) {
				int id = rs.getInt("BEAR_TYPE_ID");
				String name = rs.getString("BEAR_TYPE_NAME");
				BearType newB = new BearType(id,name);
				bt1.add(newB);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return bt1;
	}

	@Override
	public BearType getBearTyoeById(int id) {
		
		PreparedStatement pstmt = null;
		BearType bt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM CAVE WHERE BEAR_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String name  = rs.getString("BEAR_TYPE_NAME");
				bt = new BearType(id,name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bt;
	}

}
