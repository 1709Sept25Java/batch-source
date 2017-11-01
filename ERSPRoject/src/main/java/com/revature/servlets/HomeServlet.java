package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.User;
import com.revature.pojo.UserRoles;
import com.revaturedao.UserBusinessLogic;
import com.revaturedao.UserDao;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		while (session != null) {
			String username = (String) session.getAttribute("username");
			String password = (String) session.getAttribute("password");

			System.out.println(username);

			User user = new User();
			UserDao userDao = new UserDao();
			UserRoles userRole = new UserRoles();
			UserBusinessLogic ubl = new UserBusinessLogic();
			try {
				if (userDao.getUserByUserNamePassword(username, password) != null) {
					user = userDao.getUserByUserNamePassword(username, password);

					int userId = user.getUserId();
					String firstName = user.getFirstName();
					String lastName = user.getLastName();
					String EmpName = firstName + " " + lastName;
					String email = user.getEmail();
					int roleId = userRole.getRoleId();
					String role = userRole.getRole();
					out.println("<div class='middle'>");
					out.print("<p>Welcome " + EmpName + "</p>");
					out.println("<center>UserId: " + userId + "</center>");
					out.println("<center>Name: " + EmpName + "</center>");
					out.println("<center>Email: " + email + "</center>");
					out.println("<center>User-Role Id: " + roleId + "</center>");
					out.println("<center>User-Role: " + role + "</center>");
					out.write("</div></body></html>");
					request.getRequestDispatcher("/Home.html").include(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			} 
		
		
				if (ubl.adminUser(username, password) == true) {
				session.setAttribute("username", username);
				session.setAttribute("password", password);
					System.out.println(username);
					ArrayList<User> usersArrayList = new ArrayList<User>();

					try {
						usersArrayList = userDao.getEmployee();
						out.println("<table class='tableAdmin'>");
						out.println("<tr>");
						for (int i = 0; i < usersArrayList.size(); i++) {
							if (i > 0 && i % 4 == 0) {
								out.println("</tr><tr>");

								System.out.println("it's admin");
							}
							out.println("<td>" + usersArrayList.get(i) + "</td>");
						}
						out.println("</table>");
						out.print("</div>");
						out.println("</body>");
						out.println("</html>");
						request.getRequestDispatcher("/admin.html").include(request, response);

					} catch (ClassNotFoundException | SQLException e) {

						e.printStackTrace();
					}
					break;
				}
			 else {
				request.getRequestDispatcher("/Login.html").include(request, response);

				out.println("Invalid username or password");
			}

		} 

		
	}

}
