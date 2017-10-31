package com.revature.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.control.ManagerRequests;
import com.revature.domain.Reimbursement;

public class ReimbursementsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ReimbursementsServlet() {
		super();
	}
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		int eID = Integer.parseInt(req.getParameter("eID"));
		List<Reimbursement> reimbursements = ManagerRequests.userReimbursements(eID);
		for (int i=0; i<reimbursements.size(); i++) {
			pw.println(reimbursements.get(i).toString());
		}
	}
}
