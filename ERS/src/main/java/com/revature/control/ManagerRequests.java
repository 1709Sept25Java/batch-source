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
	
	public static int reviewReimbursement(int rID, int mID, int status) {
		ReimbursementDao reimbursement = new ReimbursementDaoImpl();
		return reimbursement.updateReimbursement(rID, mID, status);
	}
	
	public static List<User> viewEmployees(){
		UserDao ud = new UserDaoImpl();
		return ud.getEmployees();
		
	}
	
	public static List<Reimbursement> resolvedReimbursements() {
		ReimbursementDao rd = new ReimbursementDaoImpl();
		return rd.getResolvedReimbursements();
	}
	
	public static List<Reimbursement> userReimbursements(int id) {
		ReimbursementDao empReimbursements = new ReimbursementDaoImpl();
		return empReimbursements.getReimbursementsById(id);
	}
}
