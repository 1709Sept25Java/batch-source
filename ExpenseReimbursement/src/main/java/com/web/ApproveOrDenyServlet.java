package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReimbursementsDaoImpl;

public class ApproveOrDenyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		//req.getRequestDispatcher("Manager.html").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		ReimbursementsDaoImpl rdi = new ReimbursementsDaoImpl();
		int resolverid = Integer.parseInt(req.getParameter("resolverid"));
		int status = Integer.parseInt(req.getParameter("status"));
		int remid = Integer.parseInt(req.getParameter("remid"));
		int authorid = Integer.parseInt(req.getParameter("authorid"));
		
		// manager approve or deny request
		if(session!=null &&session.getAttribute("username")!=null) {
		
			//resp.sendRedirect(req.getContextPath()+"/ApproveDeny.html");
			//req.getRequestDispatcher("ApproveDeny.html").forward(req, resp);
		//	resp.sendRedirect("ApproveDeny.html");
			boolean approveDeny = rdi.approveDenyRequest(resolverid, status, remid, authorid);
			pw.println("successfully updated reimbursement ");
		}
	}

}
