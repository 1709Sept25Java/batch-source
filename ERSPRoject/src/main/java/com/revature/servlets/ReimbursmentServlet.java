package com.revature.servlets;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.revature.pojo.*;
import com.revaturedao.*;



public class ReimbursmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReimbursmentServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		
		 String filename = request.getParameter("reciept");
		FileInputStream file=new FileInputStream(filename);
		
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int i;
		byte[] data = new byte[16384];

		while ((i= file.read(data, 0, data.length)) != -1) {
		  buffer.write(data, 0, i);
		}

		buffer.flush();
		byte[] b =buffer.toByteArray();
		
		
		Timestamp ts = null;
		SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy HH:mm:ss");
		Date parsedDate = null;
		try {
			parsedDate = format.parse(request.getParameter("submitTime"));
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		ts = new java.sql.Timestamp(parsedDate.getTime());
		
		int authorId = Integer.parseInt(request.getParameter("authorId"));
		String type = request.getParameter("reimbType");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		UserDao userDao = new UserDao();
		
		try {
			Blob reciept = new javax.sql.rowset.serial.SerialBlob(b);
			ReimbursementDao rembDao = new ReimbursementDao();
			Reimbursement reimb = new Reimbursement();
			Reimbursmentype reimbType = new Reimbursmentype();
			reimbType.setRt_type(type);
			
			if (UserBusinessLogic.validateUser(username, password) == true) {
				System.out.println("Username and password are valid");
				
				user = userDao.getUserByUserNamePassword(username, password);
				rembDao.submitReimbursement(amount, description, reciept, ts, user, reimbType, null);
				System.out.println(reimb.getDescription()+ ""+reimb.getAmount()+ ""+reimb.getAuthorId());
			
				request.getRequestDispatcher("/Home.html").include(request, response);
				pw.println("Your request has been successfully submitted");
				
			} else {
				System.out.println("wrong username or password");
				pw.write("Unable to process your request");
				request.getRequestDispatcher("/reimbursement.html").include(request, response);
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
