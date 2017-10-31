package com.revature.servlet.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.control.EmployeeRequests;
import com.revature.domain.Reimbursement;

public class EmployeePendingReimbursementsServlet extends HttpServlet {

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		int id = (int) req.getSession().getAttribute("id");
		ObjectMapper objectMapper = new ObjectMapper();
		List<Reimbursement> reimbursements = EmployeeRequests.userReimbursements(id);
		String reimbursementsAsString = objectMapper.writeValueAsString(reimbursements);
		pw.println(reimbursementsAsString);	
	}

}
