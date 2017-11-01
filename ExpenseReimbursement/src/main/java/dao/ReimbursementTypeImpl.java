package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Connections;

public class ReimbursementTypeImpl implements ReimbursementTypeDao{

	@Override
	public List<ReimbursementType> getReimbursementType() {
		List<ReimbursementType> rt = new ArrayList<>();
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE";
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int typeId = rs.getInt("RT_ID");
				String type = rs.getString("RT_TYPE");
				ReimbursementType rt1 = new ReimbursementType(typeId,type);
				rt.add(rt1);
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
		return rt;
	}

	@Override
	public ReimbursementType getReimbursementTypeById(int typeId) {
		ReimbursementType reimbursementType=null;
		try{
			Connection con = Connections.getConnectionFromFile();
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE RT_ID = ?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, typeId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String type = rs.getString("RT_TYPE");
				reimbursementType = new ReimbursementType(typeId,type);
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
		return reimbursementType;
	}
	

}
