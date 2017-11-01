package com.revature.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.control.Login;
import com.revature.control.ManagerRequests;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;

public class EmployeeProfileServlet extends HttpServlet {

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eID = req.getParameter("eID");
		req.getSession().setAttribute("eID", eID);
		RequestDispatcher rd = req.getRequestDispatcher("views/employeeProfile.html");
		rd.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		PrintWriter pw = resp.getWriter();
//		User employee = ManagerRequests.userInfo(Integer.parseInt(eID));
//		ObjectMapper objectMapper = new ObjectMapper();
//		String userAsString = objectMapper.writeValueAsString(employee);
//		pw.print(userAsString);
		this.doGet(req, resp);
	}

}
