package com.revature.control;

import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.domain.User;

import junit.framework.TestCase;

public class ManagerRequestsTest extends TestCase {

	public void testUserInfo() {
		User user = ManagerRequests.userInfo(0);
		assertNull(user);	
	}
	
	public void testReimbursements() {
		List<Reimbursement> reimbursements = ManagerRequests.allReimbursements();
		assertFalse(reimbursements.isEmpty());	
	}

	public void testUserReimbursements() {
		List<Reimbursement> reimbursements = ManagerRequests.userReimbursements(0);
		assertTrue(reimbursements.isEmpty());	
	}
}
