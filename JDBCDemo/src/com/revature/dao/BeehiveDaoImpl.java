package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Beehive;
import com.revature.util.ConnectionUtil;

public class BeehiveDaoImpl implements BeehiveDao {
	
	public BeehiveDaoImpl() {
		super();
	}
	
	

	@Override
	public List<Beehive> getBeehives() {
		List<Beehive> bhl = new ArrayList<Beehive>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			//use a statement - remember the danger of SQL injection
			String sql = "SELECT * FROM BEEHIVE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("BEEHIVE_ID");
				int weight = rs.getInt("BEEHIVE_WEIGHT");
				Beehive newB = new Beehive(id,weight); //not creating a new beehive just saving an existing one
				bhl.add(newB);
				
			}
			con.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return bhl;
	}

	@Override
	public Beehive getBeehiveById(int id) {
		PreparedStatement pstmt = null;
		Beehive bh = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM BEEHIVE WHERE BEEHIVE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int weight = rs.getInt("BEEHIVE_WEIGHT");
				bh = new Beehive(id,weight);
			}
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return bh;
	}



	@Override
	public boolean updateBeehiveWeight(int id, int delta) {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			con.setAutoCommit(false); //manual tx management
			String sql = "UPDATE BEEHIVE SET BEEHIVE_WEIGHT =  BEEHIVE_WEIGHT + ? WHERE BEEHIVE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, delta);
			pstmt.setInt(2, id);
			if (pstmt.executeUpdate() == 1) {
				con.commit();
				return true;
			}
			else {
				con.rollback();
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
