package com.revature.util;

import javax.servlet.http.HttpServletRequest;

public class RequestViewHelper {
	
public static String process(HttpServletRequest request) {
		//dependent upon the request sent from the Load View servlet return the specified route
		switch(request.getRequestURI()) {
		
		case "/servlet-bank/login.view":
			return "partials/login.html";
		
		case "/servlet-bank/register.view":
			return "partials/register.html";
			
		case "/servlet-bank/home.view":
			return "partials/home.html";
			
		default:
			return null;
			
		}
	}
}
