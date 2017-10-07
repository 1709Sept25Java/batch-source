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
import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDaoImpl implements CaveDao {

	@Override
	public List<Cave> getCaves() {
		List<Cave> cl = new ArrayList<Cave>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			//use a statement - remember the danger of SQL injection
			String sql = "SELECT * FROM CAVE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				Cave newC = new Cave(id,name,maxBears); //not creating a new beehive just saving an existing one
				cl.add(newC);
				
			}
			con.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return cl;
		}

	@Override
	public Cave getCaveById(int id) {
		PreparedStatement pstmt = null;
		Cave cave = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM CAVE WHERE CAVE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("CAVE_NAME");
				int maxB = rs.getInt("MAX_BEARS");
				cave = new Cave(id,name,maxB);
				return cave;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
