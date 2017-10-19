package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface ReimbursementStatusDao {
	public List<ReimbursementStatus> getReimbursementStatus();
	public ReimbursementStatus getReimbursementStatusById(int id);
}