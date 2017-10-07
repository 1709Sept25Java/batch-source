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
import com.revature.domain.Beehive;
import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class BearTypeImpl implements BearTypeDao {

	@Override
	public List<BearType> getBearTypes() {
		List<BearType> bl = new ArrayList<BearType>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			//use a statement - remember the danger of SQL injection
			String sql = "SELECT * FROM BEAR_TYPE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("BEAR_TYPE_ID");
				String name = rs.getString("BEAR_TYPE_NAME");
				BearType newB = new BearType(id,name); //not creating a new beehive just saving an existing one
				bl.add(newB);
				
			}
			con.close();
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
			return bl;
		}

	@Override
	public BearType getBearTypeById(int id) {
		PreparedStatement pstmt = null;
		BearType bt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM BEAR_TYPE WHERE BEAR_TYPE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("BEAR_TYPE_NAME");
				bt = new BearType(id);
			}
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return bt;
	}

}
