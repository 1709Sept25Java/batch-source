package com.revature.control;

import java.util.List;

import com.revature.dao.*;
import com.revature.domain.*;

public final class EmployeeRequests {

	private EmployeeRequests() {
		super();
	}
	
	public static User userInfo(int id) {
		UserDao employee = new UserDaoImpl();
		return employee.getUserById(id);
	}

	public static List<Reimbursement> userReimbursements(int id) {
		ReimbursementDao empReimbursements = new ReimbursementDaoImpl();
		return empReimbursements.getReimbursementsById(id);
	}

	public static int submitReimbursement(int amount, String description, int author, int type) {
		ReimbursementDao reimbursementRequest = new ReimbursementDaoImpl();
		int success = reimbursementRequest.createReimbursement(amount, description, author, type);
		return success;
	}
	
	public static int updateEmployee(int id, String un, String pw, String fn, String ln, String em) {
		UserDao employee = new UserDaoImpl();
		return employee.updateEmployeeById(id, un, pw, fn, ln, em);
	}
}
