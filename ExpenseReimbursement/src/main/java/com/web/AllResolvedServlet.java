package com.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.Reimbursements;
import dao.ReimbursementsDaoImpl;

public class AllResolvedServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		ReimbursementsDaoImpl rdi = new ReimbursementsDaoImpl();
		ObjectMapper om = new ObjectMapper();
		// manager view all resolved request
		List<Reimbursements> resolvedList = rdi.viewReimResolvedRequest();
		String aResolvedString = om.writeValueAsString(resolvedList);
		resp.getWriter().write("{\"username\":" + aResolvedString + "}");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
