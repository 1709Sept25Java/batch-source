package com.revature.ERS_DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.util.Connect;

public class ReimbursementDaoImpl implements ReimbursementDao {

	public ReimbursementDaoImpl() {
		super();
	}

	@Override
	public List<Reimbursement> getRmbs() {
		
		PreparedStatement getRmbs = null;
		String query = "SELECT R_ID, AMOUNT, DESCRIPTION, SUBMITTED, AUTHOR FROM REIMBURSEMENTS ORDER BY SUBMITTED ASC";
		List<Reimbursement> rmbs = null;
		
		try {
			Connection c = Connect.getConnection();
			getRmbs = c.prepareStatement(query);
			ResultSet rs = getRmbs.executeQuery();
			while(rs.next()) {
				int rid = rs.getInt("R_ID");
				float amt = (float) rs.getFloat("AMOUNT");
				String descr = rs.getString("DESCRIPTION");
				Date submitDate = rs.getDate("SUBMITTED");
				String author = rs.getString("AUTHOR");
				rmbs.add(new Reimbursement(rid,amt,descr,submitDate,author));
			}
		
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rmbs;

	}
	


	@Override
	public Reimbursement getRmbById(int id) {
		PreparedStatement p = null;
		Reimbursement rmb = null;
		String query = "SELECT * FROM REIMBURSEMENTS WHERE ID = ?";
		
		try {
			Connection c = Connect.getConnection();
			p = c.prepareStatement(query);
			p.setInt(1, id);
			ResultSet rs = p.executeQuery();
			while(rs.next() ) {
				int rid = rs.getInt("R_ID");
				float amt = rs.getFloat("AMOUNT");
				String descr = rs.getString("DESCRIPTION");
				Date submitDate = rs.getDate("SUBMITTED");
				String author = rs.getString("AUTHOR");
				rmb = new Reimbursement(rid,amt,descr,submitDate,author);
			}
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rmb;
	}
	
	

	@Override
	public List<Reimbursement> getRmbByEmp(String firstName,String lastName) {
		
		List<Reimbursement> rmbs = null;
		PreparedStatement p = null;
		
		try {
			Connection c = Connect.getConnection();
			if(firstName == null || lastName == null) {
				p = c.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE FIRSTNAME LIKE ? OR LASTNAME LIKE ?");
			} else if(firstName != null & lastName != null) {
				p = c.prepareStatement("SELECT * FROM REIMBURSEMENTS WHERE FIRSTNAME LIKE ? AND LASTNAME LIKE ?");
			}
			
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return rmbs;
		
	}

	@Override
	public List<Reimbursement> getRmbBySubmitDate(Date submitDate) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void approveRmb(String decision) {
		
		
		
	}

	@Override
	public int submitRmb(float amt, String descr) {
		int submitted = 0;
		
		return submitted;
		
		
		
	}
	
	

}
