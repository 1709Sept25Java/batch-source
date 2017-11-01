package com.revature.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.control.ManagerRequests;



public class ReviewReimbursementServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		try {
			int mID = (int) req.getSession().getAttribute("id");
			String s = req.getParameter("status");
			int status = 0;
			if (s=="Approved") {
				status = 7007;
			}
			else {
				status =7014;
			}
			int rID = Integer.parseInt(req.getParameter("rID"));
			ManagerRequests.reviewReimbursement(rID, mID, status);
		}
		catch (Exception e) {
			resp.sendRedirect("manager");
		}
	}
}
