package com.revature.servlet;

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

	private static final long serialVersionUID = 1L;

	public SubmitReimbursementServlet() {
		super();
	}
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("views/reimbursement.html");
		rd.forward(req, resp);
	}

//https://robots.thoughtbot.com/html5-powered-ajax-file-uploads	
//	http://www.technicaladvices.com/2011/12/10/ajax-file-upload-to-a-java-servlet-in-html5/
	
//	@Override	
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html");
//		PrintWriter pw = resp.getWriter();
//		//http://blog.teamtreehouse.com/uploading-files-ajax
//		String image = req.getParameter("pic");
//		File imageFile = new File(image);
//		//File imageFile = new File("C:/168s.jpg");
//		FileInputStream fin = new FileInputStream(imageFile);
//		pw.println(fin.available());
//		int success;
//		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
//			String sql = "{call SUBMIT_IMAGE(?)}";
//			CallableStatement ps;
//			ps = con.prepareCall(sql);
//			ps.setBinaryStream(1, fin, (int) fin.available());
//			ps.executeUpdate();
//			con.close();
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		resp.sendRedirect("employee");
//	}

	@Override	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String description = req.getParameter("description");
		int amount = Integer.parseInt(req.getParameter("amount"));
		int type = Integer.parseInt(req.getParameter("type"));
		int id = (int) req.getSession().getAttribute("id");
		int success = EmployeeRequests.submitReimbursement(amount, description, id, type);
		if (success == 1) {
			pw.println("Success");
		}
		resp.sendRedirect("employee");
	}

	
}
