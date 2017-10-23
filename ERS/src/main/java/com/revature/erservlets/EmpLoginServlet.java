package com.revature.erservlets;
import com.revature.ers.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;

public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public EmpLoginServlet() {
        
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//HttpSession session = req.getSession();
		//PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		//req.getRequestDispatcher("Login.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		EmpLogin login = new EmpLogin();
		
		try {
			if(login.execute(username, password)==true) {
				pw.write("You are logged in as, "+username);
				session.setAttribute("username", username);
				session.setAttribute("problem", null);
				
			} else {
				pw.write("Invalid username or password");
				session.setAttribute("problem", "incorrect password");
				resp.sendRedirect("EmpLogin");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
