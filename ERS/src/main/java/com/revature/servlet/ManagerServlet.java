package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.control.ManagerRequests;
import com.revature.domain.User;

public class ManagerServlet extends HttpServlet {

	public ManagerServlet() {
		super();
	}
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		try {
			req.getRequestDispatcher("views/manager.html").include(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int id = (int) req.getSession().getAttribute("id");
		pw.println("Hello Manager "+ req.getSession().getAttribute("id"));
		User manager = ManagerRequests.userInfo(id);
		pw.print(manager.getUsername());
//		User er = EmployeeRequests.userInfo(id);
//		pw.print(er.getUsername());
		
//		resp.setContentType("application/json");
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(pw, er);	
	}
	

}
