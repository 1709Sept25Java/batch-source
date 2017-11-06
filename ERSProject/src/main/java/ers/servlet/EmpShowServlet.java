package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import ers.dao.ReimbursementsDao;
import ers.dao.ReimbursementsDaoImpl;
import ers.dao.UsersDao;
import ers.dao.UsersDaoImpl;
import ers.domain.Reimbursements;
import ers.domain.Users;

public class EmpShowServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public EmpShowServlet() {
		super();
	}
	

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		List<Reimbursements> rl = rd.getPendingByUserId(id);
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String str = om.writeValueAsString(rl);
		resp.getWriter().write(str);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		
	}
}
