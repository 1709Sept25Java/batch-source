package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.control.EmployeeRequests;
import com.revature.domain.Reimbursement;

public class ReimbursementsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ReimbursementsServlet() {
		super();
	}
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		int id = (int) req.getSession().getAttribute("id");
		List<Reimbursement> reimbursements = EmployeeRequests.userReimbursements(id);
		for (int i=0; i<reimbursements.size(); i++) {
			pw.println(reimbursements.get(i).toString());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	

}
