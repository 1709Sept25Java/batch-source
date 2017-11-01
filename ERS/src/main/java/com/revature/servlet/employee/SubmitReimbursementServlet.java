package com.revature.servlet.employee;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.control.EmployeeRequests;
import com.revature.dao.*;
import com.revature.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;

public class SubmitReimbursementServlet extends HttpServlet {
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("views/reimbursement.html");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		int id = (int) req.getSession().getAttribute("id");
		String description = req.getParameter("description");
		int amount = Integer.parseInt(req.getParameter("amount"));
		String type = req.getParameter("type");
		EmployeeRequests.submitReimbursement(amount, description, id, type);
		resp.sendRedirect("employee");
	}	
}
