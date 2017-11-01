package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.main.Util;

/**
 * Servlet implementation class GetIsManagerServlet
 */
@WebServlet("/GetIsManagerServlet")
public class GetIsManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIsManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Boolean loggedIn = (Boolean) session.getAttribute("LoggedIn");
		PrintWriter pw = response.getWriter();
		if(loggedIn) {
			Integer manId = (Integer) session.getAttribute("managerId");
			pw.write("{ \"LoggedIn\" : \"true\" , \"managerId\" : \""+manId+"\" }");
		} else {
			pw.write("{ \"LoggedIn\" : \"false\" }");
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
