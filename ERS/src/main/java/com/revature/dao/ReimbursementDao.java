package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getReimbursementsById(int id);
	public int createReimbursement(int amount, String description, int author, int type);
}