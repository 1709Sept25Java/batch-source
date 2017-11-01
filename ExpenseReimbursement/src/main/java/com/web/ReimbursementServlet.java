package com.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Reimbursements;
import dao.ReimbursementsDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementServlet extends HttpServlet {
	public ReimbursementServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ReimbursementsDaoImpl rdi = new ReimbursementsDaoImpl();
		ObjectMapper om = new ObjectMapper();
		String username = req.getParameter("username");
		
		// manager getting all reimbursement requests
		
		List<Reimbursements> pendingList = rdi.viewAllPendingRequests();
		String aPendingString = om.writeValueAsString(pendingList);
		resp.getWriter().write("{\"username\":" + aPendingString + "}");
		
		// manager view all resolved request
		
		List<Reimbursements> resolvedList = rdi.viewReimResolvedRequest();
		String aResolvedString = om.writeValueAsString(resolvedList);
		resp.getWriter().write("{\"username\":" + aResolvedString + "}");
		
		// employee view pending requests/manager viewing reimbursement request from employee

		List<Reimbursements> ePendingList = rdi.viewPendingRequests(username);
		String ePendingString = om.writeValueAsString(ePendingList);
		resp.getWriter().write("{\"username\":" + ePendingString + "}");

		// employee view resolved
		List<Reimbursements> eResolvedList = rdi.viewResolvedRequest(username);
		String eResolvedString = om.writeValueAsString(eResolvedList);
		resp.getWriter().write("{\"username\":" + eResolvedString + "}");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursementsDaoImpl rdi = new ReimbursementsDaoImpl();
		int resolverid = Integer.parseInt(req.getParameter("userId"));
		int status = Integer.parseInt(req.getParameter("statusId"));
		int remid = Integer.parseInt(req.getParameter("remId"));
		int authorid = Integer.parseInt(req.getParameter("userId"));

		// manager approve or deny request
		boolean approveDeny = rdi.approveDenyRequest(resolverid, status, remid, authorid);
		
		//employees can submit request
		int amount = Integer.parseInt(req.getParameter("amount"));
		String description = req.getParameter("description");
		//Timestamp submitted ="";
		int userId = Integer.parseInt(req.getParameter("userId"));
		int typeId = Integer.parseInt(req.getParameter("typeId"));
		
		//boolean empSubmit = rdi.submitRequest(amount, description, submitted, userId, typeId);

		//manager view all requests search by employee firstname/lastname
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		
		ObjectMapper om = new ObjectMapper();
		List<Reimbursements> allRequestList = rdi.viewAllRequest(firstname, lastname);
		String allRequestString = om.writeValueAsString(allRequestList);
		resp.getWriter().write("{\"username\":" + allRequestString + "}");
		
	}

}
