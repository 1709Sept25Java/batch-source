package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;
import com.revature.domain.Repayment;

public class FullReqDataServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		//get the id parameter appended to the url
		String ridIn = req.getParameter("rid");
		int rid = Integer.parseInt(ridIn);
		//Get the reimbursement request by id
		RepaymentDao rDao = new RepaymentDaoImpl();
		Repayment r = rDao.repaymentById(rid);
		//convert to json string
		ObjectMapper objmap = new ObjectMapper();
		String json = objmap.writeValueAsString(r);
		resp.getWriter().write(json);
	}
	
}
