package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReimbursementsDaoImpl;

public class SubmitRequestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		ReimbursementsDaoImpl rdi = new ReimbursementsDaoImpl();
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		// employees can submit request
		int amount = Integer.parseInt(req.getParameter("amount"));
		String description = req.getParameter("description");
		Timestamp submitted = req.getParameter("submitted");
		int userId = Integer.parseInt(req.getParameter("userId"));
		int typeId = Integer.parseInt(req.getParameter("typeId"));

		 boolean empSubmit = rdi.submitRequest(amount, description, submitted, userId, typeId);
	}

}
