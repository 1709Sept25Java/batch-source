package ers.servlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ers.dao.ReimbursementsDao;
import ers.dao.ReimbursementsDaoImpl;
import ers.dao.UsersDao;
import ers.dao.UsersDaoImpl;
import ers.domain.Users;

@javax.servlet.annotation.MultipartConfig
public class SubmitNewServlet extends HttpServlet{

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		req.getRequestDispatcher("submit.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		String amt = req.getParameter("amount");
		Double amount = Double.parseDouble(amt);
		String desc = req.getParameter("description");
		String type = req.getParameter("type");
		System.out.println(type);
		//InputStream in = new BufferedInputStream(req.getInputStream());
		String author = (String) session.getAttribute("username");
		UsersDao  ud = new UsersDaoImpl();
		int id = ud.getUserId(author);
		System.out.println(id);
		//byte[] image = filePart.getBytes();
		Part filePart =  req.getPart("receipt");
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
	    ReimbursementsDao rd = new ReimbursementsDaoImpl();
		rd.newReimbursements(amount, desc, fileContent, id, type);
		//rd.noReceipt(amount, desc, id, type);
		resp.sendRedirect(req.getContextPath() + "/emp_pending.html");
		
	
	}
}
