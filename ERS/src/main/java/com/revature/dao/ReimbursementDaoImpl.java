package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class ReimbursementDaoImpl implements ReimbursementDao {

	//private Connection con;
	
	public ReimbursementDaoImpl() {
		super();
	}

	@Override
	public int getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		String sql = "{call VIEW_REIMBURSEMENTS(?)}";
		CallableStatement pstmt;
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareCall(sql);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(1);
			while(rs.next()){
				int rID = rs.getInt(1);
				int amt = rs.getInt(2);
				Date submitted = rs.getDate(3); 
				int uIDAuthor = rs.getInt(4);
				int rType = rs.getInt(5);
				int rStatus = rs.getInt(6);
				Reimbursement account = new Reimbursement(rID,amt,submitted, uIDAuthor, rType, rStatus);
				reimbursements.add(account);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reimbursements.size();
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		PreparedStatement pstmt = null;
		Reimbursement r1 = null; 	
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE R_ID = ?";
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rID = rs.getInt("R_ID");
				int amount = rs.getInt("R_AMOUNT");
				int uIDAuthor = rs.getInt("U_ID_AUTHOR");
				int rType = rs.getInt("RT_TYPE");
				int rStatus = rs.getInt("RT_TYPE");
				Date rSubmitted = rs.getDate("R_SUBMITTED");
				r1 = new Reimbursement(rID,amount,rSubmitted, uIDAuthor, rType, rStatus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r1;
	}
}
