package com.revature.servlets;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.domain.Employee;
import com.revature.main.Util;

/**
 * Servlet implementation class GetEmployeeServlet
 */
@WebServlet("/GetEmployeeServlet")
public class GetEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Boolean loggedIn = (Boolean) session.getAttribute("LoggedIn");
		if(loggedIn) {
			try {
				Connection con = Util.getJDBCConnection();
				String user = (String) session.getAttribute("Username");
				Employee e = new Employee();
				e = EmployeeDaoImpl.getEmployee(con, user, e);
				List<Employee> employee = new ArrayList<Employee>();
				employee.add(e);
				PrintWriter pw = response.getWriter();
				pw.write(EmployeeDaoImpl.employeesToJSON(employee));
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
