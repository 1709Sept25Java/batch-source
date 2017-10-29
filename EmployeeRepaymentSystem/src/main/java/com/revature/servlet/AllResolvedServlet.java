package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;
import com.revature.domain.Repayment;

public class AllResolvedServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		int eid = (Integer)session.getAttribute("uid");
		
		//Get all resolved requests from the database
		RepaymentDao rDao = new RepaymentDaoImpl();
		List<Repayment> resolved = rDao.resolvedRepayments(eid);
		//Convert to JSON
		ObjectMapper objmap = new ObjectMapper();
		String json = objmap.writeValueAsString(resolved);
		//write to page
		resp.getWriter().write(json);
	}
	
}
