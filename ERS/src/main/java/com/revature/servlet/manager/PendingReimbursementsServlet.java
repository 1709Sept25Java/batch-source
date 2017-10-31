package com.revature.servlet.manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.control.EmployeeRequests;
import com.revature.control.ManagerRequests;
import com.revature.domain.Reimbursement;

public class PendingReimbursementsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PendingReimbursementsServlet() {
		super();
	}
	
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		int id = (int) req.getSession().getAttribute("id");
		List<Reimbursement> reimbursements = ManagerRequests.pendingReimbursements();
		ObjectMapper objectMapper = new ObjectMapper();
		String reimbursementsAsString = objectMapper.writeValueAsString(reimbursements);
		pw.print(reimbursementsAsString);
		//req.getRequestDispatcher("views/manager.html").include(req, resp);
	}
	
	//https://www.javatpoint.com/retrieving-image-from-oracle-database
//	@Override	
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		ServletOutputStream out = resp.getOutputStream();
//		List<Reimbursement> reimbursements = ManagerRequests.pendingReimbursements();
//		for (int i=0; i<reimbursements.size(); i++) {
//			//Blob photo;
//			if (reimbursements.get(i).getReceiptStream() != null) {
//				int length = reimbursements.get(i).getReceiptStreamLength();
//				
//				resp.setContentType("image/*");
//			    InputStream in = reimbursements.get(i).getReceiptStream();
//
//				int bufferSize = 1024;
//	            byte[] buffer = new byte[bufferSize];
//
//	            while ((length = in.read(buffer)) != -1) {
//	                out.write(buffer,0, length);
//	            }
//		    
//			}
//			
//			//pw.println(reimbursements.get(i).toString());
//		}
//	}
	

}
