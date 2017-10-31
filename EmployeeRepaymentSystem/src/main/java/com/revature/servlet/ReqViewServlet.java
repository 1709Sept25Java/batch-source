package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;

public class ReqViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		boolean mgr = (Boolean)session.getAttribute("mgr");
		System.out.println(mgr);
		if(mgr) {
			req.getRequestDispatcher("views/requestApprove.html").forward(req, resp);;
		} else {
			req.getRequestDispatcher("views/request.html").forward(req, resp);;
		}
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		int rid = Integer.parseInt(req.getParameter("rid"));
		int status = Integer.parseInt(req.getParameter("status"));
		
		//update the status
		RepaymentDao rDao = new RepaymentDaoImpl();
		rDao.updateStatus(rid, status);
		
		this.doGet(req, resp);
	}
	
}
