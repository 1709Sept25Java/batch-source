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

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;
import com.revature.util.RequestHelper;

import oracle.jdbc.OracleTypes;

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
		//https://www.javatpoint.com/http-session-in-session-tracking
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		//pw.println("Hello, "+username+". Welcome to your profile.");
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "{call LOGIN(?,?,?)}";
			pw.println("Connected to database");
			CallableStatement pstmt;
			pstmt = con.prepareCall(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.registerOutParameter(3, OracleTypes.CURSOR);
			pstmt.executeUpdate();
			ResultSet rs = (ResultSet) pstmt.getObject(3);
			while(rs.next()){
				int id = rs.getInt(1);
				String role = rs.getString(2);
				pw.println(username + " " + id+" "+role);
				HttpSession session = req.getSession();
				session.setAttribute("id", id);
				session.setAttribute("role",role);
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
