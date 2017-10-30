package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MgrEmpReqServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		String eid = req.getParameter("eid");
		session.setAttribute("eid", eid);
		req.getRequestDispatcher("views/reqsByEmp.html").forward(req, resp);
	}
	
}
