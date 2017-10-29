package ers.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ers.util.ConnectionUtil;

public class StatusDaoImpl implements StatusDao{

	@Override
	public String getStatus(int id) {
		String status = "";
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT RS_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE RS_ID = ?";
			PreparedStatement stmt = obj.establishedConnection().prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				status = rs.getString("RS_STATUS");
			}
			return status;
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return status;
	}

}
