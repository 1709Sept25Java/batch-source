package ers.servlet;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;

import ers.dao.ReimbursementsDao;
import ers.dao.ReimbursementsDaoImpl;
import ers.dao.UsersDaoImpl;
import ers.domain.Reimbursements;
import ers.domain.Users;

public class ResolvedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ResolvedServlet() {
		super();
	}

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		List<Reimbursements> rl = rd.getResolved();
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String str = om.writeValueAsString(rl);
		resp.getWriter().write(str);
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}

