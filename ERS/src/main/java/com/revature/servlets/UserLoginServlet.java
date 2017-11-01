package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.Users;

public class UserLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 2434554256305955268L;

	private UsersDaoImpl usersDaoImpl;
	

	private static String login_page = "views/Login.html";
	private static String employee_homepage = "views/EmployeeHomePage.html";
	private static String manager_homepage = "views/ManagerHomePage.html";
	

	

	public UserLoginServlet() {
		super();
		usersDaoImpl = new UsersDaoImpl();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		req.getRequestDispatcher(login_page).include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		boolean loginResult = usersDaoImpl.userLogin(username, password);
		
		if(loginResult) {
			Integer roleID = usersDaoImpl.getUserPrivileges(username);
			if (roleID == 3) { // employee
			

				session.setAttribute("username", username);
				session.setAttribute("problem", null);
				resp.sendRedirect(manager_homepage);

			}else if (roleID == 4) {//manager 

				session.setAttribute("username", username);
				session.setAttribute("problem", null);
				resp.sendRedirect(employee_homepage);
				
			} else {
				
				session.setAttribute("problem", "Not in DB");
				resp.sendRedirect("login");
			}
				
		} else {
			
			session.setAttribute("problem", "incorrect password");
			resp.sendRedirect("login");
		}	
	}
}

