package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ers.dao.ReimbursementsDao;
import ers.dao.ReimbursementsDaoImpl;
import ers.dao.UsersDao;
import ers.dao.UsersDaoImpl;
import ers.domain.Users;

public class ApproveDeclineServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		req.getRequestDispatcher("submit.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		String re_id = req.getParameter("id");
		int id = Integer.parseInt(re_id);
		String action = req.getParameter("action");
		String username = (String) session.getAttribute("username");
		
		UsersDao ud = new UsersDaoImpl();
		int r_id = ud.getUserId(username);
		
		ReimbursementsDao rd = new ReimbursementsDaoImpl();
		
		if(action.equals("approve")) {
			
			rd.approveReimbursements(id, r_id);
			resp.sendRedirect(req.getContextPath() + "/pending_reimbursements.html");
		}
		else if(action.equals("decline")) {
			rd.declineReimbursements(id, r_id);
			resp.sendRedirect(req.getContextPath() + "/pending_reimbursements.html");
		}/*else {
			resp.sendRedirect(req.getContextPath() + "/pending_reimbursements.html");
		}*/
		
	}
	
	
}
