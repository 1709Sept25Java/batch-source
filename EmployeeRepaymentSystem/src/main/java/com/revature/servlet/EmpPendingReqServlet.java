package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;
import com.revature.domain.Repayment;

public class EmpPendingReqServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		HttpSession session = req.getSession();
		int eid = (Integer)session.getAttribute("uid");
		
		//Get pending requests for logged in user
		RepaymentDao rDao = new RepaymentDaoImpl();
		List<Repayment> pending = rDao.pendingForEmp(eid);
		//Convert to JSON string
		ObjectMapper objmap = new ObjectMapper();
		String json = objmap.writeValueAsString(pending);
		//write json
		resp.getWriter().write(json);
	}
	
}
