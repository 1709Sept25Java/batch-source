package com.revature.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.control.EmployeeRequests;
import com.revature.control.ManagerRequests;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;


public class ViewEmployeesServlet extends HttpServlet {

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		List<User> employees = ManagerRequests.viewEmployees();
		ObjectMapper objectMapper = new ObjectMapper();
		String employeesAsString = objectMapper.writeValueAsString(employees);
		pw.print(employeesAsString);
	}


}
