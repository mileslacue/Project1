package com.revature.services;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;

public class EmployeeServices {
	
	private EmployeeDAOImpl empDAO = new EmployeeDAOImpl();

	public Employee getEmployee(String username, String password) {
		
		return empDAO.getEmployee(username, password);

	}
}
