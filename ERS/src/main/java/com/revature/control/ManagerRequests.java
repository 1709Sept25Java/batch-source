package com.revature.control;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;

public class ManagerRequests {

	public ManagerRequests() {
		super();
	}

	public static User userInfo(int id) {
		UserDao manager = new UserDaoImpl();
		return manager.getUserById(id);
	}

	public static List<Reimbursement> pendingReimbursements(){
		ReimbursementDao pending = new ReimbursementDaoImpl(); 
		return pending.getReimbursementsByStatus(7000);
	}
	
	public static List<Reimbursement> allReimbursements(){
		ReimbursementDao all = new ReimbursementDaoImpl();
		return all.getReimbursements();
	}
}
