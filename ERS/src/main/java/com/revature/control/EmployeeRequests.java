package com.revature.control;

import java.util.List;

import com.revature.dao.*;
import com.revature.domain.*;

public final class EmployeeRequests {

	private EmployeeRequests() {
		super();
	}
	
	public static User userInfo(int id) {
		EmployeeDao employee = new EmployeeDaoImpl();
		return employee.getUserById(id);
	}

	public static List<Reimbursement> userReimbursements(int id) {
		ReimbursementDao empReimbursements = new ReimbursementDaoImpl();
		return empReimbursements.getReimbursementById(id);
	}
}
