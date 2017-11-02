package com.revature.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.LogInDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Reimbursement;

public class Driver {
	
	public static void main(String[] args) throws SQLException, IOException {
//		Connection con = Util.getJDBCConnection();
//		String employeeJSON = EmployeeDaoImpl.employeesToJSON(EmployeeDaoImpl.getEmployees(con));
//		System.out.println(employeeJSON);
//		String str = ReimbursementDaoImpl.reimbursementsToJSON(ReimbursementDaoImpl.getReimbursements());
//		EmployeeDaoImpl.updateName(1, "Carolyn", "Rehm");
		System.out.println(Util.getDate());
	}
	
	
}
