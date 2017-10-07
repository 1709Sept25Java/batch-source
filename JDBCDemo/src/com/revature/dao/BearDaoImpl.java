package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.domain.Bear;
import com.revature.util.ConnectionUtil;

public class BearDaoImpl implements BearDao {

	@Override
	public List<Bear> getBears() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bear getBearById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int feedBear() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createBear(Bear bear) {
		int bearsCreated = 0;
		Connection con = null;
		try {
			con = ConnectionUtil.getConnectionFromFile();
			con.setAutoCommit(false);
			String sql = "INSERT INTO BEAR(BEAR_TYPE_ID,BEAR_NAME,BEAR_BIRTHDATE,BEAR_WEIGHT,CAVE_ID)"
					+ " VALUES(?,?,?,DEFAULT,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bear.getBearType().getId());
			pstmt.setString(2, bear.getName());
			pstmt.setDate(3, bear.getBirthdate());
			pstmt.setInt(4, bear.getCave().getId());
			bearsCreated = pstmt.executeUpdate();
			con.commit();
		} catch(SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch(IOException e) {
				e.printStackTrace();
			}
			if (con!=null) {
				con.close();
			}
		}
		return bearsCreated;

}
