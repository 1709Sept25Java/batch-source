package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.control.EmployeeRequests;
import com.revature.control.ManagerRequests;
import com.revature.domain.Reimbursement;

public class PendingReimbursementsServlet extends HttpServlet {

	public PendingReimbursementsServlet() {
		super();
	}
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		List<Reimbursement> reimbursements = ManagerRequests.pendingReimbursements();
		for (int i=0; i<reimbursements.size(); i++) {
			pw.println(reimbursements.get(i).toString());
		}
	}
	

}
