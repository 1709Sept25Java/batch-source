package com.revature.ERS_DAO;

import java.sql.Date;
import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getRmbs();
	
	public Reimbursement getRmbById(int id);
	
	public List<Reimbursement> getRmbByEmp(String firstName,String lastName);
	
	public List<Reimbursement> getRmbBySubmitDate(Date submitDate); //we've gotta decide on a datatype for dates first!
	
	public void approveRmb(String decision);
	
	public int submitRmb(float amt, String descr);

}
