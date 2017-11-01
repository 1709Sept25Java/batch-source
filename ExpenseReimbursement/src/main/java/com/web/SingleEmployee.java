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
import dao.Users;
import dao.UsersDaoImpl;

public class SingleEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		ReimbursementsDaoImpl rdi = new ReimbursementsDaoImpl();
		ObjectMapper om = new ObjectMapper();
		HttpSession session = req.getSession(false);
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		//manager search for employee
		if(session!=null &&session.getAttribute("username")!=null) {

			List<Reimbursements> allRequestList = rdi.viewAllRequest(firstname, lastname);
			String allRequestString = om.writeValueAsString(allRequestList);
			resp.getWriter().write("{\"username\":" + allRequestString + "}");
		}
	}

}
