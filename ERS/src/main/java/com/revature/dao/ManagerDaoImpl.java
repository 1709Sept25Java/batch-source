package com.revature.dao;
/*
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.revature.domain.RType;
import com.revature.domain.Reimbursements;
import com.revature.domain.UserRoles;
import com.revature.domain.Users;
import com.revature.util.ConnectionUtil;

public class ManagerDaoImpl implements ManagerDao {
	
	public Reimbursements getUsersById(int userid) {
		
		
			PreparedStatement pstmt = null;
			Reimbursements reimbursements = null;
			
			try (Connection con = ConnectionUtil.getConnectionFromFile()){
				String sql = "SELECT * FROM ER_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1,uidauthor);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					int rid = rs.getInt("R_ID");
					int ramnt = rs.getInt("R_AMOUNT");
					String discription = rs.getString("R_DISCRIPTION");
					String receipt = rs.getString("R_RECEIPT");
					Date  datesub = rs.getDate("R_SUBMITTED");
					Date dateres = rs.getDate("R_RESOLVED");
					String resolver = rs.getString("U_ID_RESOLVER");
					UserRoles ur = getUserRolesUrRole(resolver);
					String rttype = rs.getString("RT_TYPE");
					RType rt = getReimbursementTypeByRType(rttype);
					String status = rs.getString("RT_STATUS");
				
				//	int typeId = rs.getInt("BEAR_TYPE_ID");
				//	BearType bt = btdi.getBearTypeById(typeId); 
				
					reimbursements = new Reimbursements(uidauthor, rid, ramnt, discription, receipt, datesub, dateres, resolver, rttype, status);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return reimbursement;
		}

	private Reimbursements getReimbursementTypeByRType(String rttype) {
	
		PreparedStatement pstmt = null;
		
		Reimbursements reimbursements = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE RT_TYPE = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,rttype);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rtid = rs.getInt("RT_ID");
				
				reimbursements = new Reimbursements(rttype, rtid);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return reimbursements;
	}

	

	private UserRoles getUserRolesUrRole(String resolver) {
		
		PreparedStatement pstmt = null;
		
		UserRoles UserRoles = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE UR_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,resolver);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int urrole = rs.getInt("UR_ROLE");
				
				UserRoles = new UserRoles(urid, urrole);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return UserRoles;
	}


		
		
	

} */
