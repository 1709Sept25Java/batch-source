package com.revature.servlet;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.RepaymentDao;
import com.revature.dao.RepaymentDaoImpl;

public class BlobServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		int rid = Integer.parseInt(req.getParameter("rid"));
		//get the image
		RepaymentDao rDao = new RepaymentDaoImpl();
		byte b[] = rDao.getReceipt(rid);
		
		//set response type to an image and write it as an outputstream
		//This is what finally got me the last puzzle pieces to displaying the image
		//https://stackoverflow.com/questions/1154254/help-getting-image-from-servlet-to-jsp-page
		resp.setContentType("image/png");
		resp.setContentLength(b.length);
		resp.getOutputStream().write(b);
		
	}
	
}
