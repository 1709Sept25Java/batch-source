package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.domain.Employee;

public interface SystemDao {
	
	public static List<Employee>  getEmployees(Connection con) throws SQLException {
		return null;
	}

}
