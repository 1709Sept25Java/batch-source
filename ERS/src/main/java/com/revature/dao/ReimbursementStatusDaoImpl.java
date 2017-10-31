package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.ReimbursementStatus;
import com.revature.domain.ReimbursementType;
import com.revature.util.ConnectionUtil;

public class ReimbursementStatusDaoImpl implements ReimbursementStatusDao {
	private Connection con;
	
	public ReimbursementStatusDaoImpl() {
		super();
		try {
			this.con = ConnectionUtil.getConnectionFromFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ReimbursementStatus> getReimbursementStatus() {
		List<ReimbursementStatus> rsList = new ArrayList<>();
		String sql = "SELECT * FROM REIMBURSEMENT_STATUS";
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				int id = rs.getInt("RS_ID");
				String name = rs.getString("RS_STATUS");
				ReimbursementStatus newRStatus = new ReimbursementStatus(id,name);
				rsList.add(newRStatus);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsList;
	}


}
