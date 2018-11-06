package com.revature.util;

import javax.servlet.http.HttpServletRequest;

public class RequestViewHelper {

	
public static String process(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		
		case "/ERS/login.view":
			return "partials/login.html";
		
		case "/ERS/reimbursement.view":
			return "partials/reimbursement.html";
			
		case "/ERS/create.view":
			return "partials/create.html";
			
		default:
			return null;
			
		}
}
}
