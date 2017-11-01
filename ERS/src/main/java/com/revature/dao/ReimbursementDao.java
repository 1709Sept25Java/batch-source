package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getReimbursementsById(int id);
	public List<Reimbursement> getReimbursementsByStatus(int status);
	public List<Reimbursement> getResolvedReimbursements();
	public void createReimbursement(int amount, String description, int author, int type);
	public void updateReimbursement(int rID, int mID, int status);
}