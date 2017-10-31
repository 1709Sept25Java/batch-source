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
import com.revature.domain.ReimbursementStatus;
import com.revature.domain.ReimbursementType;

public class EmployeeReimbursementsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EmployeeReimbursementsServlet() {
		super();
	}
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/baseReimbursements.html").include(req,resp);	
	}
}
