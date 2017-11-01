package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.UsersDaoImpl;
import com.revature.domain.Reimbursements;




public class ManagerHomePageServlet extends HttpServlet {
	

	//private UsersDaoImpl usersDaoImplM;
	

	private static String manager_homepage = "views/ManagerHomePage.html";
	

	public ManagerHomePageServlet() {
		super();

	}

	private static final long serialVersionUID = -1204285434896671358L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		req.getRequestDispatcher(manager_homepage).include(req, resp);
		
		UsersDaoImpl dao = new UsersDaoImpl();
		int uidauthor = Integer.parseInt(req.getParameter("inputVal"));
		dao.getRInfoById(uidauthor);
		
		

	/*	if () {
			
			session.setAttribute("problem", uidauthor);
			
			
		} */
		

	}
	
}

