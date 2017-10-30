package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RepayStatusDao;
import com.revature.dao.RepayStatusDaoImpl;
import com.revature.domain.RepayStatus;

public class GetStatusesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		//get the statuses from the database
		RepayStatusDao rsDao = new RepayStatusDaoImpl();
		List<RepayStatus> rs = rsDao.getStatuses();
		//convert to json string
		ObjectMapper objmap = new ObjectMapper();
		String json = objmap.writeValueAsString(rs);
		//write to page
		resp.getWriter().write(json);
		
	}
	
}
