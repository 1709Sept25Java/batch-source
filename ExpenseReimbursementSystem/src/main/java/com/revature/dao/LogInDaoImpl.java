package com.revature.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.domain.Employee;
import com.revature.main.Util;

public class LogInDaoImpl {

	public static Employee checkCredentials(String username, String password) throws SQLException, IOException {
		Connection con = Util.getJDBCConnection();
		Employee e = new Employee();
		String checkUserSQL = "{call CHECK_USER(?,?)}";
		CallableStatement cs = con.prepareCall(checkUserSQL);
		cs.setString(1, username);
		cs.registerOutParameter(2,java.sql.Types.INTEGER);; //0 if user does not occur, 1 if it does
		cs.execute();
		int userOccurs = cs.getInt(2);
		if (userOccurs == 0) {
			e = null;
		}
		else {
			String checkPassSQL = "{call CHECK_PASSWORD(?,?,?)}";
			CallableStatement cs2 = con.prepareCall(checkPassSQL);
			cs2.setString(1, username);
			cs2.setString(2, password);
			cs2.registerOutParameter(3, java.sql.Types.INTEGER);
			cs2.execute();
			int passCorrect = cs2.getInt(3);
			if (passCorrect == 0) {
				e.setEmployeeId(0);
				return e;
			}
			else {
				e = EmployeeDaoImpl.getEmployee(con, username, e);
			}
		}
		return e;
	}

}
