package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RepayTypeDao;
import com.revature.dao.RepayTypeDaoImpl;
import com.revature.domain.RepayType;

public class GetTypesServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		RepayTypeDao rtDao = new RepayTypeDaoImpl();
		List<RepayType> types = rtDao.getTypes();
		
		ObjectMapper objmap = new ObjectMapper();
		String json = objmap.writeValueAsString(types);
		
		resp.getWriter().write(json);
	}
	
}
