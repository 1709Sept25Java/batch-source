package com.revature.util;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

	public static String process(HttpServletRequest req){
		
		switch(req.getParameter("destination")) {
		case "bears" : return "bear";
		case "caves" : return "cave";
		default : return "error";
		}
	}
}
