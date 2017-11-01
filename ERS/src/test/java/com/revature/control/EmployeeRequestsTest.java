package com.revature.control;

import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.domain.User;

import junit.framework.TestCase;

public class EmployeeRequestsTest extends TestCase {

	public void testUserInfo() {
		User user = EmployeeRequests.userInfo(0);
		assertNull(user);	
	}
	
	public void testUserReimbursements() {
		List<Reimbursement> reimbursements = EmployeeRequests.userReimbursements(0);
		assertEquals(0,reimbursements.size());	
	}
	

}
