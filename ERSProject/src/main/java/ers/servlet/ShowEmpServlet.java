package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;

import ers.dao.ReimbursementsDao;
import ers.dao.ReimbursementsDaoImpl;
import ers.dao.UsersDao;
import ers.dao.UsersDaoImpl;
import ers.domain.Reimbursements;
import ers.domain.Users;

public class ShowEmpServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public ShowEmpServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		req.getRequestDispatcher("pending_reimbursements.html").include(req, resp);
		
		/*UsersDao ud = new UsersDaoImpl();
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		String username = req.getParameter("username");
		System.out.println(username);
		int id = ud.getUserId(username);
		System.out.println(id);
		List<Reimbursements> rl = rd.getPendingByUserId(id);
		System.out.println(rl.toString());
		resp.setContentType("application/json");
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String str = om.writeValueAsString(rl);
		resp.getWriter().write("{\"reimbursements\":"+str+"}");*/
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		UsersDao ud = new UsersDaoImpl();
		int id = ud.getUserId(username);
		session.setAttribute("id", id);
		
		resp.sendRedirect(req.getContextPath() + "/show_emp.html");
	}
}
