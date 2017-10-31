package com.revature.dao;

import java.util.List;

import com.revature.domain.ReimbursementType;


public interface ReimbursementTypeDao {
	public List<ReimbursementType> getReimbursementTypes();
	public ReimbursementType getReimbursementTypeById(int id);
	public int getReimbursementTypeByName(String name);
}
