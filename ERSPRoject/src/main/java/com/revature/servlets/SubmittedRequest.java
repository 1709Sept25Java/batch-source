package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.revature.pojo.*;
import com.revaturedao.ReimbursementDao;
import com.revaturedao.UserBusinessLogic;
import com.revaturedao.UserDao;

public class SubmittedRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubmittedRequest() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if (session != null) {
			response.setContentType("text/html");
			String username = (String) session.getAttribute("username");
			String password = (String) session.getAttribute("password");
			System.out.println(username +""+password);
			UserDao userDao = new UserDao();
			ReimbursementDao rembDao = new ReimbursementDao();
			Reimbursement reimb = new Reimbursement();


			try {
			while (UserBusinessLogic.validateUser(username, password) == true) {
					User user = userDao.getUserByUserNamePassword(username, password);
					System.out.println("user exists" + user.getFirstName());
					int id = user.getUserId();
					if (rembDao.getReimbursementById(id) == true) {
						System.out.println(id);
						reimb = rembDao.getReimbStatus(id);
						Reimbursmentype type = new Reimbursmentype();
						reimb.setRt_typeId(type);
						ReimbursmentStatus status = new ReimbursmentStatus();
						reimb.setRt_statusId(status);
						
						out.println("<table style='width:100%'>");
						  out.println("<tr>");
						    out.println("<th>R-Id</th>");
						    out.println("<th>Amount</th>"); 
						    out.println("<th>Descrp</th>");
						    out.println("<th>Submitted</th>");
						    out.println("<th>Resolved</th>");
						    out.println("<th>Type</th>");
						    out.println("<th>Status</th>");
						  out.println("</tr><tr>");
						    out.println("<td>" +reimb.getRt_id() +"</td>");
						    out.println("<td>" +reimb.getAmount() +"</td>");
						    out.println("<td>" +reimb.getDescription() +"</td>");
						    out.println("<td>" +reimb.getSubmitDate() +"</td>");
						    out.println("<td>" +reimb.getResolvedDate() +"</td>");
						    out.println("<td>" +type.getRt_type()+"</td>");
						    out.println("<td>" +status.getRs_status() +"</td>");
						  out.println("</tr></table>");
						  
					}
				 else {
					System.out.println("wrong id");
				} break;
			}
			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
