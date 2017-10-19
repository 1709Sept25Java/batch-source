package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

	public static String process (HttpServletRequest req) throws IOException {
		switch(req.getParameter("destination")){
		case "employee":
			return "employee";
		case "manager":
			return "manager";
		default:
			return "error";
		}
	}
}