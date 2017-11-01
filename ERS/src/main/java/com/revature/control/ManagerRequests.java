package com.revature.control;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;

//Manager Requests - this utility class is an intermediary between
//servlets and DAO to prevent direct access to DB

public class ManagerRequests {

	public ManagerRequests() {
		super();
	}

	//Given the manager id, returns their user information
	public static User userInfo(int id) {
		UserDao manager = new UserDaoImpl();
		return manager.getUserById(id);
	}

	//Returns all pending reimbursements for all employees
	public static List<Reimbursement> pendingReimbursements(){
		ReimbursementDao pending = new ReimbursementDaoImpl(); 
		return pending.getReimbursementsByStatus(7000);
	}
	
	//Return all reimbursements regardless of status
	public static List<Reimbursement> allReimbursements(){
		ReimbursementDao all = new ReimbursementDaoImpl();
		return all.getReimbursements();
	}
	
	//Allows manager to approve or deny reimbursement requests
	public static void reviewReimbursement(int rID, int mID, int status) {
		ReimbursementDao reimbursement = new ReimbursementDaoImpl();
		reimbursement.updateReimbursement(rID, mID, status);
	}
	
	//List of employees so manager can view employees
	public static List<User> viewEmployees(){
		UserDao ud = new UserDaoImpl();
		return ud.getEmployees();
		
	}
	
	//Allows manager to view all resolved reimbursements 
	public static List<Reimbursement> resolvedReimbursements() {
		ReimbursementDao rd = new ReimbursementDaoImpl();
		return rd.getResolvedReimbursements();
	}
	
	//Allows manager to view reimbursements for one employee
	public static List<Reimbursement> userReimbursements(int id) {
		ReimbursementDao empReimbursements = new ReimbursementDaoImpl();
		return empReimbursements.getReimbursementsById(id);
	}
}
