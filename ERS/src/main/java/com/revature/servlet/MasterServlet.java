package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;
import com.revature.util.RequestHelper;
import javax.servlet.http.HttpServlet;


public class MasterServlet extends HttpServlet {

	public MasterServlet() {
		super();
	}
	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/index.html");
		rd.forward(request, response);	
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		//pw.println("Hello, "+username+". Welcome to your profile.");
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			pw.println("Connection made");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
