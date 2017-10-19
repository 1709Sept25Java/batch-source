package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.domain.ReimbursementType;
import com.revature.util.ConnectionUtil;

public class ReimbursementTypeDaoImpl implements ReimbursementTypeDao {

	private Connection con;
		
	public ReimbursementTypeDaoImpl() {
		super();
		try {
			this.con = ConnectionUtil.getConnectionFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ReimbursementType> getReimbursementTypes() {
		List<ReimbursementType> rtList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT_TYPE";
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("RT_ID");
				String name = rs.getString("RT_TYPE");
				ReimbursementType newRType = new ReimbursementType(id,name);
				rtList.add(newRType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rtList;
	}

	@Override
	public ReimbursementType getReimbursementTypeById(int id) {
		PreparedStatement pstmt = null;
		ReimbursementType rt = null; 	
		String sql = "SELECT * FROM REIMBURSEMENT_TYPE WHERE RT_ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name  = rs.getString("RT_TYPE");
				rt = new ReimbursementType(id,name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rt;
	}
	
}