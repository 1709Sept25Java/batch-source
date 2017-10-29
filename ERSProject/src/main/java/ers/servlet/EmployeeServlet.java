package ers.servlet;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import ers.dao.UsersDaoImpl;
import ers.domain.Users;

public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();
	}

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UsersDaoImpl udi = new UsersDaoImpl();
		List<Users> ul = udi.getEmployees();
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		String empStr = om.writeValueAsString(ul);
		resp.getWriter().write("{\"employees\":"+empStr+"}");
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
