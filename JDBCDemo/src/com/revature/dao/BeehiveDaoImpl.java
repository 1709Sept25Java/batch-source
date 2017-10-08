package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

import com.revature.domain.Beehive;
import com.revature.util.ConnectionUtil;

public class BeehiveDaoImpl implements BeehiveDao{

	public BeehiveDaoImpl() {
		super();
	}
	
	@Override 
	public List<Beehive> getBeehives() {
		List<Beehive> bh1 = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			//use a Statement - remember the danger of SQL injection
			String sql = "SELECT * FROM BEEHIVE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("BEEHIVE_ID");
				int weight = rs.getInt("BEEHIVE_WEIGHT");
				Beehive newB = new Beehive(id, weight);
				bh1.add(newB);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return bh1;
	}

	@Override
	public Beehive getBeehiveById(int id) {
		PreparedStatement pstmt = null;
		Beehive bh = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT *  FROM BEEHIVE WHERE BEEHIVE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int weight = rs.getInt("BEEHIVE_WEIGHT");
				bh = new Beehive(id, weight);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return bh;
	}

	@Override
	public boolean updateBeehiveWeight(int id, int delta) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			con.setAutoCommit(false); //manual tx management 
			String sql = "UPDATE BEEHIVE SET BEEHIVE WEIGHT = BEEHIVE WEIGHT + ? WHERE BEEHIVE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, delta);
			pstmt.setInt(2, id);
			if(pstmt.executeUpdate() == 1) {
				con.commit();
				return true;
			} else {
				con.rollback();
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
}
