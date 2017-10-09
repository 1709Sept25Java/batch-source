package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.domain.Department;
import com.revature.util.ConnectUtil;

public class DepDaoImpl implements DepartmentDao{

	@Override
	public Department getDepartmentById(int id) {
		
		PreparedStatement pstmt = null;
		Department dep = null;
		
		try(Connection con = ConnectUtil.getConnection()){
			
			String sql = "SELECT ? FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dep;
	}

	@Override
	public int raiseSalary(int amt) {
		return 0;
	}

}
