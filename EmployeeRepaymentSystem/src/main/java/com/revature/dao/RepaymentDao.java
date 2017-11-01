package com.revature.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.List;

import com.revature.domain.Repayment;

public interface RepaymentDao {

	//Function to create new Reimbursement request
	public boolean newRepayment(int eid,double amt,String summary,InputStream in,Timestamp submit,int type);
	
	public List<Repayment> pendingRepayments(int eid);
	
	public List<Repayment> resolvedRepayments(int eid);
	
	public List<Repayment> pendingForEmp(int eid);
	
	public List<Repayment> resolvedForEmp(int eid);
	
	public Repayment repaymentById(int rid);
	
	public void updateStatus(int rid,int mid,int sid);
	
	public byte[] getReceipt(int rid);
}
