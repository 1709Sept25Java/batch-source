package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;
import com.revature.domain.Repayment;

public class AllPendingServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		int eid = (Integer)session.getAttribute("uid");
		
		//Get all pending reimbursements
		RepaymentDao rDao = new RepaymentDaoImpl();
		List<Repayment> pending = rDao.pendingRepayments(eid);
		//Convert to JSON object
		ObjectMapper objmap = new ObjectMapper();
		//Write to file
		String json = objmap.writeValueAsString(pending);
		resp.getWriter().write(json);
		
	}
	
}
