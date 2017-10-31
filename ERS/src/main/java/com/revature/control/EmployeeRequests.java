package com.revature.control;

import java.util.List;

import com.revature.dao.*;
import com.revature.domain.*;


//EmployeeRequests is a utility class to 
//act as intermediary between dao and servers
//no direct access to database

public final class EmployeeRequests {

	private EmployeeRequests() {
		super();
	}
	
	public static User userInfo(int id) {
		UserDao ud = new UserDaoImpl();
		return ud.getUserById(id);
	}

	public static List<Reimbursement> userReimbursements(int id) {
		ReimbursementDao rd = new ReimbursementDaoImpl();
		return rd.getReimbursementsById(id);
	}

	public static int submitReimbursement(int amount, String description, int author, String type) {
		ReimbursementDao rd = new ReimbursementDaoImpl();
		return rd.createReimbursement(amount, description, author, type);
	}
	
	public static int updateEmployee(int id, String un, String pw, String fn, String ln, String em) {
		UserDao ud = new UserDaoImpl();
		return ud.updateEmployeeById(id, un, pw, fn, ln, em);
	}
	
}

