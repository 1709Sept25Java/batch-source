package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	public int getReimbursements();

//	public List<Reimbursement> getReimbursements();
	public Reimbursement getReimbursementById(int id);
}