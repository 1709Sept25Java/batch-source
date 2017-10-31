package com.revature.servlet.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.control.EmployeeRequests;
import com.revature.domain.User;

public class EmployeeInformationServlet extends HttpServlet {

	public EmployeeInformationServlet() {
		super();
	}
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		int id = (int) req.getSession().getAttribute("id");
		User employee = EmployeeRequests.userInfo(id); 
		ObjectMapper objectMapper = new ObjectMapper();
		String userAsString = objectMapper.writeValueAsString(employee);
		pw.println(userAsString);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
