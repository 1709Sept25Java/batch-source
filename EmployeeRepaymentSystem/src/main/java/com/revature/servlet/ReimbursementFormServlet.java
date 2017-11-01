package com.revature.servlet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;

public class ReimbursementFormServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		
		if(session != null && session.getAttribute("uid") != null) {
			req.getRequestDispatcher("views/requestform.html").forward(req, resp);;
		} else {
			resp.sendRedirect("main");
		}
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		
		int uid = (Integer) session.getAttribute("uid");
		double amt = Double.parseDouble(req.getParameter("amount"));
		String desc = req.getParameter("desc");
		String file = req.getParameter("img");
		InputStream in = new BufferedInputStream(req.getInputStream());
		
		
		int type = Integer.parseInt(req.getParameter("type"));
		Timestamp submit = new Timestamp(System.currentTimeMillis());
		
		RepaymentDao rDao = new RepaymentDaoImpl();
		boolean success = rDao.newRepayment(uid,amt, desc, in, submit, type);
		
		if(success) {
			resp.sendRedirect("employee");
		} else {
			resp.sendRedirect("newrequest");
		}
	}
	
}
