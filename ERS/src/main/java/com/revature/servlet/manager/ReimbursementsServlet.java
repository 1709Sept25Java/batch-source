package com.revature.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
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
		try {
			String eID = (String) req.getSession().getAttribute("eID");
			List<Reimbursement> reimbursements = ManagerRequests.userReimbursements(Integer.parseInt(eID));
			ObjectMapper objectMapper = new ObjectMapper();
			String reimbursementsAsString = objectMapper.writeValueAsString(reimbursements);
			pw.println(reimbursementsAsString);
		} catch (Exception e) {
			resp.sendRedirect("managerEmployees");
		}
	}
	
}
