package com.revature.servlet;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.*;
import com.revature.domain.Bear;

public class BearServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public BearServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	PrintWriter pw = response.getWriter();
		request.getRequestDispatcher("views/Base.html").include(request,response);
		BearDaoImpl bdl = new BearDaoImpl();
		
		for (Bear b : bdl.getBears()) {
			pw.println("<p>" + b.toString() + "</p>");
		}
		
		pw.println("<a href=\"home\">Go back!!</a>");
		pw.write("</div></body></html>");
*/
		BearDaoImpl bdl = new BearDaoImpl();
		List<Bear> bearList = bdl.getBears();
		response.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String bearString = om.writeValueAsString(bearList);
		response.getWriter().write("{\"bears\":"+bearString+"}");
}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		//System.out.println(request.getParameterNames());
		BearDaoImpl bdl = new BearDaoImpl();
		Bear b = new Bear();
		System.out.println(request.getParameter("name"));
		//bdl.createBear(b);
	}

}