package com.web;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersDaoImpl udi = new UsersDaoImpl();
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		if (session != null) {
			
			String username = (String) session.getAttribute("username");
			//pw.println("Hello "+username+" welcome to your profile");
			Users users = udi.getUserByUsername(username);
			String userString = om.writeValueAsString(users);
			resp.getWriter().write("{\"username\":" + userString + "}");
		} else {
			resp.sendRedirect("login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
