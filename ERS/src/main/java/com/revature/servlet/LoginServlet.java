package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.control.Login;
import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;
import com.revature.util.RequestHelper;

import oracle.jdbc.OracleTypes;

import javax.servlet.http.HttpServlet;


public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("views/index.html");
		rd.forward(req, resp);		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User userLogin = Login.login(username, password);
		if (userLogin != null) {
			pw.println(userLogin.getuID()+" "+userLogin.getUsername() + " " + userLogin.getRole());
			req.getSession().setAttribute("id", userLogin.getuID());
			req.getSession().setAttribute("username", userLogin.getUsername());
		}
		else {
			pw.println("<p>Login invalid</p>");
			req.getRequestDispatcher("views/index.html").include(req, resp);
		}
		String destination = userLogin.getRole().toLowerCase();
		resp.sendRedirect(destination);
	}
}
