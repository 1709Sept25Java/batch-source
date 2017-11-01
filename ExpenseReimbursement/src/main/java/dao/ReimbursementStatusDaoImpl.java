package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Connections;

public class ReimbursementStatusDaoImpl implements ReimbursementStatusDao{

	@Override
	public List<ReimbursementStatus> getReimbursementStatus() {
		List<ReimbursementStatus> rs1 = new ArrayList<>();
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int statusId = rs.getInt("RS_ID");
				String status = rs.getString("RS_STATUS");
				ReimbursementStatus rs2 = new ReimbursementStatus(statusId,status);
				rs1.add(rs2);
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs1;
	}

	@Override
	public String getStatusById(int statusId) {
		String result = null;
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT RS_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE RS_ID=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, statusId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("RS_STATUS").equals("Approved")) {
					result = "Approved";
					return result;
				}else if(rs.getString("RS_STATUS").equals("Pending")) {
					result="Pending";
					return result;
					
				}else {
					result = "Denied";
					return result;
				}
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ReimbursementStatus getReimbursementStatusById(int statusId) {
		PreparedStatement pstmt = null;
		ReimbursementStatus rst = null;
		try{
			
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE RS_ID = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, statusId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String status = rs.getString("RS_STATUS");
				rst = new ReimbursementStatus(statusId, status);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}

	
	

}
