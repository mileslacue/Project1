package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.EmployeeDAOImpl;
import com.revature.models.Employee;
import com.revature.util.RequestViewHelper;

//Service class to access the DAO methods 
public class EmployeeServices {

	
	private EmployeeDAOImpl empDAO = new EmployeeDAOImpl();
	Logger log = LogManager.getLogger(EmployeeServices.class);
	
	public Employee getEmployee(int Id) {
		return empDAO.getEmployee(Id);
	}
	
	//Checks credentials against the database user table returns Employees info if valid
	public Employee getEmployee(String username, String password) {

		// Check if the employees credentials are valid
		if (validCredentials(username, password)) {
			return empDAO.getEmployee(username, password);
		} else {
			log.warn("Invalid Credentials, user not found.");
			return null;
		}
	}

	//validates employees credentials 
	public boolean validCredentials(String username, String password) {
		return empDAO.checkEmployee(username, password);
	}
}
