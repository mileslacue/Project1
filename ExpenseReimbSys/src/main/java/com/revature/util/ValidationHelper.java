package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.EmployeeServices;

public class ValidationHelper {

	public static String process(HttpServletRequest request) throws IOException {
		
		EmployeeServices userService = new EmployeeServices();
		ObjectMapper mapper = new ObjectMapper();
		
		switch(request.getRequestURI()) {
		
		case "/servlet-bank/username.validate": 
			String username = mapper.readValue(request.getInputStream(), String.class);
			
			if(userService.isUsernameAvailable(username)) return username;
			else return null;
			
		case "/servlet-bank/email.validate":
			String emailAddress = mapper.readValue(request.getInputStream(), String.class);
			
			if(userService.isEmailAvailable(emailAddress)) return emailAddress;
			else return null;
			
		default:
			return null;
		}
	}
}