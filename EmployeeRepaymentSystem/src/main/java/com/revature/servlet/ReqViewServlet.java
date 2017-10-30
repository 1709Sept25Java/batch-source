package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ReqViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		boolean mgr = (Boolean)session.getAttribute("mgr");
		if(mgr) {
			req.getRequestDispatcher("views/requestApprove.html").forward(req, resp);;
		} else {
			req.getRequestDispatcher("views/request.html").forward(req, resp);;
		}
	}
	
}
