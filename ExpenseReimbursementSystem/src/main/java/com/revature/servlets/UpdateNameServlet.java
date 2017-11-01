package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;

/**
 * Servlet implementation class UpdateNameServlet
 */
@WebServlet("/UpdateNameServlet")
public class UpdateNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect("Views/Login.html");
		} else {
			try {
				
				Integer id = (Integer) session.getAttribute("managerId");
				String newName = request.getParameter("newName");
				int spaceIndex = newName.indexOf(" ");
				//if (spaceIndex == null) {
				//	PrintWriter pw = response.getWriter()
				//	pw.write("Please enter both first and last name as you would like it to appear in the ERS system");
				//}
				String newFirst = newName.substring(0,spaceIndex);
				String newLast = newName.substring(spaceIndex+1);
				EmployeeDaoImpl.updateName(id, newFirst, newLast);
				String e = (String) session.getAttribute("email");
				response.sendRedirect("Profile.html?email="+e);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect("Views/Login.html");
		} else {
			try {
				
				Integer id = (Integer) session.getAttribute("managerId");
				String newName = request.getParameter("newName");
				int spaceIndex = newName.indexOf(" ");
				//if (spaceIndex == null) {
				//	PrintWriter pw = response.getWriter()
				//	pw.write("Please enter both first and last name as you would like it to appear in the ERS system");
				//}
				String newFirst = newName.substring(0,spaceIndex);
				String newLast = newName.substring(spaceIndex+1);
				EmployeeDaoImpl.updateName(id, newFirst, newLast);
				String e = (String) session.getAttribute("email");
				response.sendRedirect("Profile.html?email="+e);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
			}
	}

}
