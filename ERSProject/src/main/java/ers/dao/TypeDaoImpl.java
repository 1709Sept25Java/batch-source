package ers.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ers.util.ConnectionUtil;

public class TypeDaoImpl implements TypeDao {

	@Override
	public String getType(int id) {
		String type = "";
		
		try {
			ConnectionUtil obj = ConnectionUtil.getinstance();
			String sql = "SELECT RT_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE RT_ID = ?";
			PreparedStatement stmt = obj.establishedConnection().prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				type = rs.getString("RT_TYPE");
			}
			return type;
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return type;
	}

	
}
