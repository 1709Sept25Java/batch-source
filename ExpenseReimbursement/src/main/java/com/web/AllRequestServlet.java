package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Reimbursements;
import dao.ReimbursementsDaoImpl;

public class AllRequestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ReimbursementsDaoImpl rdi = new ReimbursementsDaoImpl();
		ObjectMapper om = new ObjectMapper();
		// manager getting all pending reimbursement requests
		
		List<Reimbursements> pendingList = rdi.viewAllPendingRequests();
		String aPendingString = om.writeValueAsString(pendingList);
		resp.getWriter().write("{\"username\":" + aPendingString + "}");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
