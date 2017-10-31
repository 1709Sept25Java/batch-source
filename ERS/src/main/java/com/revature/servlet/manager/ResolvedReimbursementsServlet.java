package com.revature.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.control.ManagerRequests;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;

public class ResolvedReimbursementsServlet extends HttpServlet {
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		List<Reimbursement> reimbursements = ManagerRequests.resolvedReimbursements();
		ObjectMapper objectMapper = new ObjectMapper();
		String reimbursementsAsString = objectMapper.writeValueAsString(reimbursements);
		pw.print(reimbursementsAsString);
	}
}
