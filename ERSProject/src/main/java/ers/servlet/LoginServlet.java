package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ers.dao.UsersDao;
import ers.dao.UsersDaoImpl;
import ers.domain.Users;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		req.getRequestDispatcher("index.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UsersDao ud = new UsersDaoImpl();
		int ur_id = ud.getUserRoleId(username, password);
		Users u = new Users();

		if(ur_id == 1) {
			resp.sendRedirect(req.getContextPath() 
					+ "/employee.html");
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			u = ud.createUser(username, password);
			session.setAttribute("user_id", u.getU_id());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
		} else if (ur_id == 2){
			resp.sendRedirect(req.getContextPath() 
					+ "/manager.html");
			session.setAttribute("username", username);
			session.setAttribute("password", password);
		}else {
			boolean user = ud.isValidUsername(username);
			if(user == false) {
				session.setAttribute("problem", "invalid username");
				resp.sendRedirect(req.getContextPath() 
						+ "/login1.html");
			}
			else {
				boolean pw = ud.isValidPassword(username, password);
				if(pw == false) {
					session.setAttribute("problem", "incorrect password");
					resp.sendRedirect(req.getContextPath() 
							+ "/login2.html");
				}
				else {
					session.setAttribute("problem", "can not login");
					resp.sendRedirect("login");
				}
			}
		}
		
	}

}
