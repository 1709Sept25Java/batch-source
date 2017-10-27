package com.revature.dao;

import java.sql.Timestamp;

public interface RepaymentDao {

	//Function to create new Reimbursement request
	boolean newRepayment(int eid,double amt,String summary,String file,Timestamp submit,int type);
	
}
