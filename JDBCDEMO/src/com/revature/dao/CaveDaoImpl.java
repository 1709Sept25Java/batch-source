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
		List<Cave> cl = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			// use a Statement - remember the danger of SQL Injection
			String sql = "SELECT * FROM CAVE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				Cave newC = new Cave(id, name, maxBears);
				cl.add(newC);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
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

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cave;
	}

}
